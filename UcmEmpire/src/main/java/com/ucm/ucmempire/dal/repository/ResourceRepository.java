package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.ResourceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends CrudRepository<ResourceEntity ,Integer> {

    Optional<List<ResourceEntity>> findResourceEntitiesById(Integer player_id);
}
