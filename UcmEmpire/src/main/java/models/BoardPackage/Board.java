package models.BoardPackage;

import models.Constantes;
import models.Entity;
import models.biomes.*;

import java.util.ArrayList;

public class Board {

    private String name;
    private ArrayList<ArrayList<Case>> board;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
        this.board = boardGeneration();
    }

    private ArrayList<ArrayList<Case>> boardGeneration() //TODO : include all generation in 1 loop based on the constant of biome and modulo with a list of different biome type from the factory
    {
        // init the x dimension
        ArrayList<ArrayList<Case>> boardList = new ArrayList<>(Constantes.DIMENSION_BOARD);

        BiomeFactory biomeFactory = new BiomeFactory();

        // Init the y dimension
        for (int i = 0; i < Constantes.DIMENSION_BOARD; i++) {
            boardList.add(new ArrayList<>());

        }

        // For the V1 init map in plain biome

        IBiomes biomes = biomeFactory.getBiome(BiomeType.PLAIN);

        for (int i = 0; i < Constantes.DIMENSION_BOARD; i++) {

            for (int j = 0; j < Constantes.DIMENSION_BOARD; j++) {

                boardList.get(i).add(j, biomes.creationBiome());
            }
        }

        // Hard code for ressource on map
        CaseSpecial<EnumRessourcersTemp> ressourceCase = new CaseSpecial<>(EnumRessourcersTemp.BOIS);
        boardList.get(2).set(5, ressourceCase);

        ressourceCase = new CaseSpecial<>(EnumRessourcersTemp.PIERRE);
        boardList.get(2).set(2, ressourceCase);


        return boardList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<Case>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Case>> board) {
        this.board = board;
    }

    public void removeEntity(int xPosition,int yPosition) {
        board.get(xPosition).get(yPosition).setContent(null);

    }

    public void setCase(int xPosition,int yPosition, Entity newEntity ) {

        board.get(xPosition).get(yPosition).setContent(newEntity);

    }

    private ArrayList<ArrayList<Case>> boardAutoGeneration () //TODO : work in progress by Damien
    {
        // init the x dimension
        ArrayList<ArrayList<Case>> boardList = new ArrayList<>(Constantes.DIMENSION_BOARD);

        BiomeFactory biomeFactory = new BiomeFactory();

        // Init the y dimension
        for (int i = 0; i < Constantes.DIMENSION_BOARD; i++) {
            boardList.add(new ArrayList<>());

        }

        IBiomes biomes = biomeFactory.getBiome(BiomeType.PLAIN);

        for (int i = 0; i < boardList.size() ; i++) {



            for (int j = 0; j < boardList.get(i).size() ; j++) {



            }

        }

        return boardList;
    }
}
