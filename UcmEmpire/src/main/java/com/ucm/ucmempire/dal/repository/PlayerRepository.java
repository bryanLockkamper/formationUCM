package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity , Long> {

//  @Query(value = "SELECT p FROM PlayerEntity p WHERE p.login = :login and p.password = :password")
    Optional<PlayerEntity> findByLoginAndPassword(String login , String password);

}
