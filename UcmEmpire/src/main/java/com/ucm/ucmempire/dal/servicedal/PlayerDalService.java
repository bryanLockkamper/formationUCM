package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlayerDalService {
    PlayerEntity findByLoginAndPassword(String login , String password);
}
