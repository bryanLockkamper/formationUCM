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
        game.getBoard().setSquare(new Position(0,0), new Soldier(0, 20, 5, 5));
        ((Character) (game.getBoard().getBoard().get(0).get(0).getContent())).setMoveLeft(new Position(0,11));
        game.endRound();
        // TODO BRYAN : FAIRE PLUS DE TESTS AVEC UN PUTAIN DE NOM EXPLICITE
        Soldier character = new Soldier(0,20,5, 5);
        character.setMoveLeft(new Position(0,11));
        character.setPa(0);
        assertEquals(character, game.getBoard().getBoard().get(0).get(5).getContent());
    }

}