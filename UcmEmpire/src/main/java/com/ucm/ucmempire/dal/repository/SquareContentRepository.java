package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.SquareContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareContentRepository extends CrudRepository<SquareContent , Integer> {
}
