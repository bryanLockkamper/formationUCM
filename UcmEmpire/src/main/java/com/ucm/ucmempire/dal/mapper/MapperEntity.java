package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.entity.SquareEntity;
import com.ucm.ucmempire.models.biomes.BiomeFactory;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.biomes.IBiomes;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;

import java.util.List;

public class MapperEntity {

    public BoardEntity boardToBoardEntity (Board board)
    {
      return new BoardEntity(null, board.getName());
    }

    public Board boardEntityToBoard (BoardEntity boardEntity)
    {
        return new Board(boardEntity.getName(),/* (List<>) squareEntityToSquare() */  )
    }

    public Square squareEntityToSquare (SquareEntity squareEntity)
    {

        BiomeFactory biomeFactory = new BiomeFactory(); //TODO : need to declare in the swagger the right string to insert into the square

        if (squareEntity.isSpecial())
        {
            return new SpecialSquare(/* entityToEntityGame(squareEntity.getContents) */,squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
        }

        return new Square(squareEntity.getContents(),squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
    }
}
