package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.mapper.MapperBoardSquare;
import com.ucm.ucmempire.dal.repository.BoardRepository;
import com.ucm.ucmempire.models.boardPackage.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BoardDalServiceimpl implements BoardDalService{
    private BoardRepository boardRepository;
    private MapperBoardSquare mapperBoardSquare;
    private SquareDalService squareDalService;


    @Autowired
    public BoardDalServiceimpl(BoardRepository boardRepository,MapperBoardSquare mapperBoardSquare,SquareDalService squareDalService) {
        this.boardRepository = boardRepository;
        this.mapperBoardSquare = mapperBoardSquare;
        this.squareDalService = squareDalService;
    }

    @Override
    public Optional<BoardEntity> findBoardEntityById(Integer id_player) {
        return this.boardRepository.findBoardEntityById(id_player);
    }

    @Override
    public BoardEntity save(Board board) {
        BoardEntity boardEntity = mapperBoardSquare.boardToBoardEntity(board);
        System.out.println(squareDalService.saveList(boardEntity.getSquareEntity()));

        return this.boardRepository.save(this.mapperBoardSquare.boardToBoardEntity(board));
    }
}
