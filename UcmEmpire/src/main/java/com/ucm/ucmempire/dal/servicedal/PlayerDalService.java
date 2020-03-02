package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerDalService {
    Optional<PlayerEntity> findByLoginAndPassword(String login , String password);
    List<PlayerEntity> saveBoard (List<Integer> idPlayersList, BoardEntity boardEntity);
}
