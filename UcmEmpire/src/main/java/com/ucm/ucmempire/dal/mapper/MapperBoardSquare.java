package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperBoardSquare {

    private MapperEntities mapperEntities = new MapperEntities();

    public BoardEntity boardToBoardEntity (Board board)
    {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(board.getName());
        List<SquareEntity> squareEntityList = new ArrayList<>();

        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                Square s = board.getBoard().get(i).get(j);
                SquareEntity squareEntity = squareToSquareEntity(s);

                squareEntity.setPositionSquare(i+":"+j);


                squareEntity.getContents().stream()
                            .forEach(data -> data.setSquare(squareEntity));

                squareEntityList.add(squareEntity);
            }
        }
        boardEntity.setSquareEntity(squareEntityList);
        return boardEntity;
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

         //TODO DAMIEN : need to declare in the swagger the right string to insert into the square

        if (squareEntity.isSpecial())
        {

            Resource resource = squareEntity.getContents().stream()
                    .filter(r -> r.getEntityGame() instanceof ResourceEntity)
                    .map(data ->(Resource) mapperEntities.entityGameToEntity(data.getEntityGame()))
                    .findFirst().orElse(null);

            List<Farmer> farmersList = squareEntity.getContents().stream()
                    .filter(e -> Constants.TYPE_FARMER.equals(e.getEntityGame().getType()))
                    .map(data -> {
                        Farmer newFarm =  (Farmer) mapperEntities.entityGameToEntity(data.getEntityGame());
                        newFarm.setResourceHarvesting(resource.getResourceName());
                        return newFarm;
                    })
                    .collect(Collectors.toList());

            return new SpecialSquare(resource, BiomeType.valueOf(squareEntity.getBiome()),farmersList);
        } else
        {
            if (squareEntity.getContents() == null || squareEntity.getContents().isEmpty())
            {
                return new Square(null,squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));

            } else return new Square(mapperEntities.entityGameToEntity(squareEntity.getContents().get(0).getEntityGame()),squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
        }

    }

    public SquareEntity squareToSquareEntity (Square square)
    {
        boolean isSpecial = false;
        List<SquareContent> squareContentList = new ArrayList<>();
        if (square instanceof SpecialSquare)
        {

            isSpecial = true;
            if ((((SpecialSquare) square).getFarmers() != null))
            {
                for (Entity e:((SpecialSquare) square).getFarmers()) {

                    squareContentList.add(new SquareContent( null,mapperEntities.entityToEntityGame(e),square.getContent().getHp()));
                }
            }

        } else
        {

            EntityGame entityGame = square.getContent() == null ? null : mapperEntities.entityToEntityGame(square.getContent());

            squareContentList.add(new SquareContent(null,entityGame,entityGame == null ? null : entityGame.getHp()));
        }
        System.out.println("coucou je suis dans le mapper :"+square.getBiome().getType());
        return new SquareEntity(null,square.isWalkable(),square.isBuildable(),isSpecial,square.getBiome().getType(),null,squareContentList);
    }


}
