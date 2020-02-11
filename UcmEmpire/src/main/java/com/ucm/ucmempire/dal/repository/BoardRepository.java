package com.ucm.ucmempire.dal.repository;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity , Long> {

    // @Query(value = "Select b From BoardEntity b JOIN PlayerEntity p ON b.id = p.boardEntity.id Where p.id = :player_id")
    Optional<BoardEntity> findBoardEntityById (Integer id_player);

}