package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity , Long> {

    Optional<PlayerEntity> findByLoginAndPassword(String login, String password);

}
