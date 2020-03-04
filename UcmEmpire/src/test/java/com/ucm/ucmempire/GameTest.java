package com.ucm.ucmempire;

import com.ucm.ucmempire.controllers.Game;
import com.ucm.ucmempire.controllers.Global;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void endRound_automove() {
        Game game = new Game();
        game.getBoard().setSquare(new Position(0,0), new Soldier(20, 0, 5, 5));
        ((Character) (game.getBoard().getBoard().get(0).get(0).getContent())).setMoveLeft(new Position(0,11));
        game.endRound();
        Soldier character = new Soldier(20,0,5, 5);
        character.setMoveLeft(new Position(0,11));
        assertEquals(character, game.getBoard().getBoard().get(0).get(5).getContent());
    }

}