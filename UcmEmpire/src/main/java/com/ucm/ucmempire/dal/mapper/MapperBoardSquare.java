package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.entity.SquareEntity;
import com.ucm.ucmempire.models.biomes.BiomeFactory;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperBoardSquare {

    private Mapper mapper = new DozerBeanMapper();
    private MapperEntities mapperEntities;

    public BoardEntity boardToBoardEntity (Board board)
    {
        return mapper.map(board,BoardEntity.class);
    }

    public Board boardEntityToBoard (BoardEntity boardEntity)
    {
        return mapper.map(boardEntity,Board.class);
    }

    public Square squareEntityToSquare (SquareEntity squareEntity)
    {

        BiomeFactory biomeFactory = new BiomeFactory(); //TODO DAMIEN : need to declare in the swagger the right string to insert into the square

        if (squareEntity.isSpecial())
        {

            List<Farmer> farmersList = squareEntity.getContents().stream()
                    .map(data -> (Farmer) mapperEntities.entityGameToEntity(data.getEntityGame()))
                    .collect(Collectors.toList());

            return new SpecialSquare((Resource) mapperEntities.entityGameToEntity(squareEntity.getContents().get(0).getEntityGame()), BiomeType.valueOf(squareEntity.getBiome()),farmersList);
        } else
        {
            return new Square(mapperEntities.entityGameToEntity(squareEntity.getContents().get(0).getEntityGame()),squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
        }

    }


}
