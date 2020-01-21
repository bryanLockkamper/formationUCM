package controllers;

import models.*;
import models.Character;
import models.boardPackage.Board;
import models.boardPackage.Square;
import models.units.Soldier;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
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
        return game;
    }

    public void run() {
        beginRound();
            // TODO: 21-01-20 Attendre la fin du timer ou que le joueur termine son tour(bouton)
        endRound();
    }

    private void beginRound() {
        player1.buildEntity();
        player1.autoHarvestResources();
    }

    private void endRound() {
        player1.autoMoveUnits();
        player1.maxPa();
    }

    private boolean nextRound() {
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
