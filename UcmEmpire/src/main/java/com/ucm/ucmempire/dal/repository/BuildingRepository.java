package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends CrudRepository<BuildingEntity , Integer> {

    Optional<List<BuildingEntity>> findBuildingEntitiesById(Integer id_player);
}
