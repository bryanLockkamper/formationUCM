package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity , Long> {

    @Query(value = "SELECT p FROM PlayerEntity p WHERE p.login = :login and p.password = :password")
    PlayerEntity findByLoginAndPassword(@Param("login") String login , @Param("password") String password);


}
