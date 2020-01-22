package controllers;

import models.Player;
import models.boardPackage.Board;

public class Game implements Runnable{
    private static Game game;
    private boolean endRound;
    private Player player1;
    private Player player2;
    private Board board;

    private Game() {

    }

    public static Game getGame(Player player1, Player player2, Board board) {
        if (game == null) {
            game = new Game();
            game.player1 = new Player();
            game.player2 = new Player();
            game.board = new Board();
        }
        return game;
    }

    public static Game getGame() {
        if (game == null)
            game = new Game();
        return game;
    }

    public synchronized void run() {
        beginRound();
        try {
            this.wait();// Attend qu'on le réveil
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endRound();
    }

    private void beginRound() {
        System.out.println("debut tour");
        player1.buildEntity();
        player1.autoHarvestResources();
        endRound = false;
    }

    private void endRound() {
        System.out.println("fin tour");
        player1.autoMoveUnits();
        player1.maxPa();
    }

    public boolean nextRound() {
        endRound = true;
        return !(player1.hasLost() || player2.hasLost());
    }

    public static void setGame(Game game) {
        Game.game = game;
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
