package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.repository.PlayerRepository;

public class PlayerDalServiceImpl implements PlayerDalService {

    private PlayerRepository playerRepository;

    @Override
    public PlayerEntity findByLoginAndPassword(String login, String password) {
        return playerRepository.findByLoginAndPassword(login,password);
    }
}
