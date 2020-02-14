package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerDalServiceImpl implements PlayerDalService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerDalServiceImpl(PlayerRepository repository) {
        this.playerRepository = repository;
    }

    @Override
    public Optional<PlayerEntity> findByLoginAndPassword(String login, String password) {
        return playerRepository.findByLoginAndPassword(login,password);
    }

    public void save(PlayerEntity playerEntity) {
         playerRepository.save(playerEntity);
    }
}
