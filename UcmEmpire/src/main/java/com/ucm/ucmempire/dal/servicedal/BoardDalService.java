package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.models.boardPackage.Board;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BoardDalService {

    Optional<BoardEntity> findBoardEntityById (Integer id_player);
    BoardEntity save (Board board);
}
