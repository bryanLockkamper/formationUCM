package models.boardPackage;

import controllers.pathfinding.Position;
import models.Constants;
import models.Entity;
import models.biomes.*;
import models.resources.ResourceName;

import java.util.ArrayList;

public class Board {

    private String name;
    private ArrayList<ArrayList<Square>> board;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
        this.board = boardGeneration();
    }

    private ArrayList<ArrayList<Square>> boardGeneration() //TODO : include all generation in 1 loop based on the constant of biome and modulo with a list of different biome type from the factory
    {
        // init the x dimension
        ArrayList<ArrayList<Square>> boardList = new ArrayList<>(Constants.DIMENSION_BOARD);

        BiomeFactory biomeFactory = new BiomeFactory();

        // Init the y dimension
        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            boardList.add(new ArrayList<>());

        }

        // For the V1 init map in plain biome

        IBiomes biomes = biomeFactory.getBiome(BiomeType.PLAINS);

        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {

            for (int j = 0; j < Constants.DIMENSION_BOARD; j++) {

                boardList.get(i).add(j,biomes.biomeCreation());
            }
        }

        // Hard code for ressource on map
        SpecialSquare ressourceCase = new SpecialSquare(ResourceName.WOOD);
        boardList.get(2).set(5,ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.STONE);
        boardList.get(2).set(2,ressourceCase);


        return boardList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<Square>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Square>> board) {
        this.board = board;
    }

    public void removeEntity(int xPosition,int yPosition) {
        board.get(xPosition).get(yPosition).setContent(null);
    }

    public void setSquare(Position position, Entity newEntity ) {
        board.get(position.getX()).get(position.getY()).setContent(newEntity);
    }

    private ArrayList<ArrayList<Square>> boardAutoGeneration () //TODO : work in progress by Damien
    {
        // init the x dimension
        ArrayList<ArrayList<Square>> boardList = new ArrayList<>(Constants.DIMENSION_BOARD);

        BiomeFactory biomeFactory = new BiomeFactory();

        // Init the y dimension
        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            boardList.add(new ArrayList<>());

        }

        IBiomes biomes = biomeFactory.getBiome(BiomeType.PLAINS);

        for (int i = 0; i < boardList.size() ; i++) {

            for (int j = 0; j < boardList.get(i).size() ; j++) {

            }
        }

        return boardList;
    }
}
