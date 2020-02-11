package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayerDalServiceImpl implements PlayerDalService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerDalServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<PlayerEntity> findByLoginAndPassword(String login, String password) {
        return  playerRepository.findByLoginAndPassword(login,password);
    }
}
