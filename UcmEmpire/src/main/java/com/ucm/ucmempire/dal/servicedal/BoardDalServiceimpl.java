package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BoardDalServiceimpl implements BoardDalService{
    private BoardRepository boardRepository;

    @Autowired
    public BoardDalServiceimpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Optional<BoardEntity> findBoardEntityById(Integer id_player) {
        return this.boardRepository.findBoardEntityById(id_player);
    }
}
