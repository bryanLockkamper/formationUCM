package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.*;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

                boardList.get(i).add(j, biomes.biomeCreation());
            }
        }

        // Hard code for ressource on map
        SpecialSquare ressourceCase = new SpecialSquare(ResourceName.WOOD);
        ressourceCase.setSpecial(true);
        boardList.get(2).set(5, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.STONE);
        ressourceCase.setSpecial(true);
        boardList.get(2).set(2, ressourceCase);

        // Hard code for ennemy
        boardList.get(3).get(5).setContent(new Soldier(10, 5, 5));


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

    public void removeEntity(int xPosition, int yPosition) {
        board.get(xPosition).get(yPosition).setContent(null);
    }

    public void setSquare(Position position, Entity newEntity) {
        board.get(position.getX()).get(position.getY()).setContent(newEntity);
    }

    private ArrayList<ArrayList<Square>> boardAutoGeneration() //TODO : work in progress by Damien
    {
        // init the x dimension
        ArrayList<ArrayList<Square>> boardList = new ArrayList<>(Constants.DIMENSION_BOARD);

        BiomeFactory biomeFactory = new BiomeFactory();

        // Init the y dimension
        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            boardList.add(new ArrayList<>());

        }

        IBiomes biomes = biomeFactory.getBiome(BiomeType.PLAINS);

        for (int i = 0; i < boardList.size(); i++) {

            for (int j = 0; j < boardList.get(i).size(); j++) {

            }
        }

        return boardList;
    }

    /**
     * @param position_old position actuelle du Character
     * @param position_new Position où le caractère sera déplacer
     */
    public void moveEntity(Position position_old, Position position_new) {
        if (board.get(position_old.getX()).get(position_old.getY()).getContent() instanceof Character) {
            Character character = (Character) board.get(position_old.getX()).get(position_old.getY()).getContent();
            if (board.get(position_old.getX()).get(position_old.getY()) instanceof SpecialSquare)
                ((SpecialSquare) board.get(position_old.getX()).get(position_old.getY())).removeFarmer((Farmer) character);
            else
                board.get(position_old.getX()).get(position_old.getY()).setContent(null);

            if (board.get(position_new.getX()).get(position_new.getY()) instanceof SpecialSquare) {
                if (character instanceof Farmer)
                    ((SpecialSquare) board.get(position_new.getX()).get(position_new.getY())).addFarmer((Farmer) character);
            } else
                board.get(position_new.getX()).get(position_new.getY()).setContent(character);
        }
    }

    /*public List<Pair<Position, Square>> getBoardDTO() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        return board.stream()
                .map(squares -> {
                    j.set((j.intValue() + 1) % board.get(0).size());
                    if (j.intValue() == 0)
                        i.getAndIncrement();
                    System.out.println(i.get() + j.get());
                    return new Pair<>(new Position(i.get(), j.get()), squares.get(j.get()));
                })
                .collect(Collectors.toList());
    }*/
}
