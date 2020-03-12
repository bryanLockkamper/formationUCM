package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity , Integer> {

    Optional<PlayerEntity> findByLoginAndPassword(String login, String password);

    List<PlayerEntity> findByIdIn (List<Integer> idPlayers);

    Optional<PlayerEntity> findById(Integer user_id);

    Optional<PlayerEntity> findByLogin(String login);
}
