package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.entity.SquareEntity;
import com.ucm.ucmempire.models.Constants;
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

import java.util.ArrayList;
import java.util.Comparator;
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
        ArrayList<ArrayList<Square>> squares = new ArrayList<>();

        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            squares.add(new ArrayList<>());
        }


        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {

            for (int j = 0; j < Constants.DIMENSION_BOARD; j++) {

                int finalI = i;
                int finalJ = j;
                Square square = boardEntity.getSquareEntity().stream()
                        .filter(data -> data.getPositionSquare().equals(finalI +":"+ finalJ))
                        .findFirst()
                        .map(s-> squareEntityToSquare(s))
                        .orElse(null);

                squares.get(i).add(j, square);
            }
        }
        
        return new Board(boardEntity.getName(),squares);
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
