package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.buildings.Barracks;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.buildings.ProdBuilding;
import com.ucm.ucmempire.services.HarvestService;
import javafx.geometry.Pos;

import java.util.stream.Collectors;

public class Game implements Runnable {
    private final int MINUTES_TOUR = 2, SECONDES_TOUR = 0;
    private boolean endRound;
    private Player player1;
    private Player player2;
    private Player player;
    private Board board;
    HarvestService harvestService = new HarvestService();

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.player = player1;
        this.board = board;
    }

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player();
        player = player1;
        this.board = new Board("test");
    }

    public synchronized void run() {
        beginRound();
        try {
            this.wait(this.MINUTES_TOUR * 60 * 1000 + this.SECONDES_TOUR * 1000);// Attend qu'on le réveil
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endRound();
    }

    private void beginRound() {
        System.out.println("debut tour");
        buildEntity();
        endRound = false;
    }

    private void buildEntity() {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                Entity entity = board.getBoard().get(i).get(j).getContent();
                if (entity instanceof ProdBuilding && ((ProdBuilding) entity).getIdUser() == player.getId()) {
                    if (((ProdBuilding) entity).decrementCounter() != null && ((ProdBuilding) entity).getProd().size() > 0) {
                        if (board.getBoard().get(i+1).get(j+1).getContent() == null) {
                            board.getBoard().get(i+1).get(j+1).setContent(((ProdBuilding) entity).getProd().get(0));
                        } else {
                            ((ProdBuilding) board.getBoard().get(i).get(j).getContent()).getEntities().add(((ProdBuilding) entity).getProd().get(0));
                        }
                        player.addEntity(((ProdBuilding) entity).getProd().get(0));
                        ((ProdBuilding) entity).getProd().remove(0);
                    }
                }
            }
        }
    }

    public void endRound() {
        System.out.println("fin tour");
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                if (board.getBoard().get(i).get(j).getContent() instanceof Character && ((Character) board.getBoard().get(i).get(j).getContent()).getMoveLeft() != null && ((Character) board.getBoard().get(i).get(j).getContent()).getIdUser() == player.getId()) {
                    Position second = ((Character) board.getBoard().get(i).get(j).getContent()).getMoveLeft();
                    AStarService aStarService = new AStarService(board, new Position(i, j), second);
                    Character character = (Character) board.getBoard().get(i).get(j).getContent();
                    PositionDTO positionDTO = aStarService.run(((Character) board.getBoard().get(i).get(j).getContent()).getPa());
                    board.moveEntity(new Position(i, j), positionDTO.getPosition());
                    character.move(positionDTO);
                    if (positionDTO.getPosition().equals(second))
                        character.setMoveLeft(null);
                    else
                        character.setMoveLeft(second);
                    board.getBoard().get(positionDTO.getPosition().getX()).get(positionDTO.getPosition().getY()).setContent(character);
                }
            }
        }
        board.getBoard()
                .stream()
                .map(squares -> squares
                        .stream()
                        .filter(square -> square instanceof SpecialSquare)
                        .map(square -> harvestService.autoHarvestResources((SpecialSquare) square, player))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        player.maxPa();
        if (player.getId() == player1.getId())
            player = player2;
        else
            player = player1;
    }

    public boolean nextRound() {
        return !board.hasLost();
    }

    public boolean isEndRound() {
        return endRound;
    }

    public void setEndRound(boolean endRound) {
        this.endRound = endRound;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
