package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlayerDalService {
    Optional<PlayerEntity> findByLoginAndPassword(String login , String password);
    Optional<PlayerEntity> save(PlayerEntity playerEntity);
}
