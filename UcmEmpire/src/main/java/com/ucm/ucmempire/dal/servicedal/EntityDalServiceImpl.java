package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.EntityGame;
import com.ucm.ucmempire.dal.repository.EntityRepository;

import java.util.List;
import java.util.Optional;

public class EntityDalServiceImpl implements EntityDalService {
    private EntityRepository entityRepository;

    public EntityDalServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Optional<List<EntityGame>> findEntityGamesById(Integer id_player) {
        return this.entityRepository.findEntityGamesById(id_player);
    }
}
