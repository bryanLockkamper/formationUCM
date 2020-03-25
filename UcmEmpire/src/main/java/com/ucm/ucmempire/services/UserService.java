package com.ucm.ucmempire.services;

import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PlayerDalServiceImpl playerDalService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return playerDalService.findByLogin(login).orElse(null);
    }
}
