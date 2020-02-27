package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.SquareEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareRepository extends CrudRepository<SquareEntity , Integer> {
}
