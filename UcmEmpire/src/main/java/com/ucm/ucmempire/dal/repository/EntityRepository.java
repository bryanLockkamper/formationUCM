package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.EntityGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntityRepository extends CrudRepository<EntityGame , Integer> {

    Optional<List<EntityGame>> findEntityGamesById(Integer id_player);
}
