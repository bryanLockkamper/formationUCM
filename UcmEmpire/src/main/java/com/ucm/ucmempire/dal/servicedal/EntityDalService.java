package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.EntityGame;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EntityDalService {

    Optional<List<EntityGame>> findEntityGamesById(Integer id_player);
}
