package com.ucm.ucmempire;

import com.sun.xml.bind.v2.TODO;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HasLostTest {

    @Test
    public void haslostEmptyUnitList_true(){

        //Arrange
        Player player1 = new Player(1, "win");
        Player player2 = new Player(2, "lost");
        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        Board board = new Board();
        board.setPlayerList(playerArrayList);

        //Act
        boolean result = board.hasLost();

        //Assert
        assertTrue(result);

    }

    @Test
    public void haslostNormalCase_false(){

        //Arrange
        Farmer f1 = new Farmer(1,10, 10 );
        Farmer f3 = new Farmer(1,10, 10 );
        Soldier s1 = new Soldier(1,10,10);
        Soldier s3 = new Soldier(1,10,10);

        Farmer f2 = new Farmer(2,10, 10 );
        Farmer f4 = new Farmer(2,10, 10 );
        Soldier s2 = new Soldier(2,10,10);
        Soldier s4 = new Soldier(2,10,10);

        Player player1 = new Player(1, "win");
        Player player2 = new Player(2, "lost");

        ArrayList<Player> playerArrayList1 = new ArrayList<>();

        ArrayList<Entity> playerEntityList1 = new ArrayList<>();
        ArrayList<Entity> playerEntityList2 = new ArrayList<>();

        playerEntityList1.add(f1);
        playerEntityList1.add(s1);
        playerEntityList1.add(f3);
        playerEntityList1.add(s3);

        playerEntityList2.add(s2);
        playerEntityList2.add(s4);
        playerEntityList2.add(f2);
        playerEntityList2.add(f4);

        playerArrayList1.add(player1);
        playerArrayList1.add(player2);

        player1.setEntities(playerEntityList1);
        player2.setEntities(playerEntityList2);

        Board board = new Board();
        board.setPlayerList(playerArrayList1);

        //Act
        boolean result = board.hasLost();

        //Assert
        assertFalse(result);
    }
}
