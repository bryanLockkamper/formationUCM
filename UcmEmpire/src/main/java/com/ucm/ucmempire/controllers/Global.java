package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.servicedal.PlayerDalService;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class Global {
    private Board board = new Board("test");
    private PlayerDalService playerDalService;

    @Autowired
    Global(PlayerDalService playerDalService) {
        this.playerDalService = playerDalService;
    }

    @PostMapping("/move")
    public void move(@RequestBody List<Position> positions) {
        AStarService aStarService = new AStarService(board, positions.get(0), positions.get(1));
        Position position = aStarService.run(20);
        board.moveEntity(positions.get(0), position);
    }

    @GetMapping("/")
    public ArrayList<ArrayList<Square>> getBoard() {
        return board.getBoard();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PlayerDTOLogin playerDTO) {
        Optional<PlayerEntity> player = playerDalService.findByLoginAndPassword(playerDTO.getPseudo(), playerDTO.getPwd());
        if (player.isPresent())
            return ResponseEntity.ok().body(player.get());
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public String register(@RequestBody PlayerDTORegister playerDTO) {
        PlayerEntity playerEntity = new PlayerEntity(playerDTO.getLastname(), playerDTO.getFirstname() , playerDTO.getPseudo() , playerDTO.getPwd());
        playerDalService.save(playerEntity);
        return "200";
    }
}
