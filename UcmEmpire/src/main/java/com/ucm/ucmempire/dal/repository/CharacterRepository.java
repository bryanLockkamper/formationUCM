package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.CharacterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity , Integer> {

    Optional<List<CharacterEntity>> findCharacterEntitiesById(Integer id_player);
}
