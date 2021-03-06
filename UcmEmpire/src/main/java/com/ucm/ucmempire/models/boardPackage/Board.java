package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.biomes.*;
import com.ucm.ucmempire.models.dto.BoardDTO;
import com.ucm.ucmempire.models.dto.CellDTO;
import com.ucm.ucmempire.models.dto.SquareDTO;
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

    ArrayList<Player> playerList;

    public Board() {
        this.board = boardGeneration();
        this.playerList= new ArrayList<>();
    }

    public Board(String name) {
        this();
        this.name = name;
    }

    public Board(String name, ArrayList<ArrayList<Square>> board) {
        this.name = name;
        this.board = board;
    }

    public Board (BoardDTO boardDTO)
    {
        this.name = boardDTO.getName();

        ArrayList<ArrayList<Square>> boardSquareList = new ArrayList<>(boardDTO.getSquareDTOList().size());

        // init the column
        for (int i = 0; i <boardDTO.getSquareDTOList().size(); i++) { boardSquareList.add(new ArrayList<>()); }

        for (int i = 0; i< boardDTO.getSquareDTOList().size();i++)
        {
            for (int j = 0; j < boardDTO.getSquareDTOList().get(i).size();j++)
            {
                boardSquareList.get(i).set(j,new Square(boardDTO.getSquareDTOList().get(i).get(j)));
            }
        }
        this.board = boardSquareList;

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
        boardList.get(2).set(5, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.STONE);
        boardList.get(2).set(2, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.FOOD);
        boardList.get(0).set(10, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.WOOD);
        boardList.get(6).set(5, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.STONE);
        boardList.get(8).set(2, ressourceCase);

        ressourceCase = new SpecialSquare(ResourceName.FOOD);
        boardList.get(10).set(10, ressourceCase);



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
        Square cell = board.get(position.getX()).get(position.getY());
        //Give the resources of the entity to the enemy player, if it's a farmer.
        Entity e = cell.getContent();
        if(e instanceof Farmer){
            plunderFarmerResources((Farmer)e);
        }

        cell.setContent(newEntity);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
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

    public Square getSquare(CellDTO cellDTO) {
        return board.get(cellDTO.getRowId()).get(cellDTO.getId());
    }

    public boolean hasLost() {
//        Une partie se termine lorsque :
//        - le player abandonne (boutton)
//        - le player adverse ne possède plus d'unité
//        - Nombre de ressources =

//        for (Player player : this.playerList) {
//
//            if (player.isHasLost()) return true;
//
//            else if (player.getEntities().size() <= 0) return true;
//
//            int nbRessource = player.getResources(ResourceName.STONE) + player.getResources(ResourceName.WOOD) + player.getResources(ResourceName.FOOD);
//
//            if (nbRessource >= Constants.NB_RESSOURCE_VICTORY) {
//                return true;
//            }
//        }
        return false;
    }

    public void testPlunderResources(Farmer farmer){
        plunderFarmerResources(farmer);
    }

    private void plunderFarmerResources(Farmer farmer){
        playerList.stream().filter(p -> !p.getEntities().contains(farmer)).findFirst()
                .ifPresent(enemyPlayer -> farmer.getInventory().keySet()
                        .forEach(resource -> {

                            if (enemyPlayer.getActualQuantityTotalRessources() + farmer.getInventory().get(resource) <= enemyPlayer.getMaxResources())
                            {
                                enemyPlayer.getResource(resource).setHp( enemyPlayer.getResource(resource).getHp()+(farmer.getInventory().get(resource)));
                            } else  enemyPlayer.getResource(resource).setHp(enemyPlayer.getResource(resource).getHp()+ (enemyPlayer.getMaxResources() - enemyPlayer.getActualQuantityTotalRessources()));

                        }));
        playerList.stream().filter(p -> p.getEntities().contains(farmer)).findFirst()
                .ifPresent(thisPlayer -> thisPlayer.removeInventaryResourcesFromPlayerResources(farmer));
    }

}
