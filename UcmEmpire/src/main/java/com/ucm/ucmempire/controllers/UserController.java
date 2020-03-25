package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.configuration.HashConfig;
import com.ucm.ucmempire.configuration.JwtTokenProvider;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.entity.Role;
import com.ucm.ucmempire.dal.servicedal.PlayerDalService;
import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.dto.PlayerDTOInfo;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    HashConfig hashConfig;

    @Autowired
    PlayerDalService playerDalService;

    @ApiOperation(value = "Appelé a chaque fois qu'un joueur veut se connecter")
    @PostMapping("/login")
    public ResponseEntity signin(@RequestBody PlayerDTOLogin data)
    {
        try {
            String login = data.getPseudo();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,(data.getPassword())));
            String token = jwtTokenProvider.createToken(login,this.playerDalService.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Login "+ login+ "not found")).getRoles().stream().map(Role::getAuthority).collect(Collectors.toList()),new PlayerDTOInfo(this.playerDalService.findByLogin(login).get()));
            Map model = new HashMap();
            model.put("token",token);
            model.put("username",login);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e)
        {
            throw new BadCredentialsException("Invalid login/password");
        }
    }

    @ApiOperation(value = "Appelé a chaque fois qu'un joueur voudrat s'enregistrer")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PlayerDTORegister playerDTO) {

        playerDTO.setPassword(hashConfig.getPasswordEncoder().encode(playerDTO.getPassword()));
        PlayerEntity playerEntity = new PlayerEntity(playerDTO);
        playerDalService.save(playerEntity);


        return ResponseEntity.ok("200");
    }


}
