package com.ucm.ucmempire;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.buildings.Granary;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class PlunderResourcesTest {
    @Test
    public void plunderResources_FarmerWithoutResources_true(){
        //ARRANGE
        //Setting datas for player 1
        Player player1 = new Player();
        player1.setId(1);
        player1.setName("killer");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 0));
        map2.add(new Resource(ResourceName.WOOD, 0));
        Entity g1 = new Granary(50, 1, map2);
        Entity g2 = new Granary(50, 1, map2);
        Entity g3 = new Granary(50, 1, map2);
        Entity g4 = new Granary(50, 1, map2);
        Entity g5 = new Granary(50, 1, map2);
        Entity g6 = new Granary(50, 1, map2);
        Entity g7 = new Granary(50, 1, map2);
        Entity g8 = new Granary(50, 1, map2);
        Entity g9 = new Granary(50, 1, map2);
        Entity g10 = new Granary(50, 1, map2);
        Entity g11 = new Granary(50, 1, map2);
        player1.addEntity(g1);
        player1.addEntity(g2);
        player1.addEntity(g3);
        player1.addEntity(g4);
        player1.addEntity(g5);
        player1.addEntity(g6);
        player1.addEntity(g7);
        player1.addEntity(g8);
        player1.addEntity(g9);
        player1.addEntity(g10);
        player1.addEntity(g11);

        Farmer f1 = new Farmer(1,10, 10 );
        player1.addEntity(f1);

        //setting datas for player 2
        Player player2 = new Player();
        player2.setId(2);
        player2.setName("killed");
        Entity g21 = new Granary(50, 2, map2);
        Entity g22 = new Granary(50, 2, map2);
        Entity g23 = new Granary(50, 2, map2);
        Entity g24 = new Granary(50, 2, map2);
        Entity g25 = new Granary(50, 2, map2);
        Entity g26 = new Granary(50, 2, map2);
        Entity g27 = new Granary(50, 2, map2);
        Entity g28 = new Granary(50, 2, map2);
        Entity g29 = new Granary(50, 2, map2);
        Entity g210 = new Granary(50,2, map2);
        Entity g211 = new Granary(50,2, map2);
        player2.addEntity(g21);
        player2.addEntity(g22);
        player2.addEntity(g23);
        player2.addEntity(g24);
        player2.addEntity(g25);
        player2.addEntity(g26);
        player2.addEntity(g27);
        player2.addEntity(g28);
        player2.addEntity(g29);
        player2.addEntity(g210);
        player2.addEntity(g211);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        Board board = new Board();
        board.setPlayerList(playerArrayList);

        //ACT
        board.testPlunderResources(f1);

        //ASSERT
        Assert.assertEquals(50, player1.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(50, player1.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(50, player1.getResource(ResourceName.FOOD).getHp());

        Assert.assertEquals(50, player2.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(50, player2.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(50, player2.getResource(ResourceName.FOOD).getHp());
    }


    @Test
    public void plunderResources_FarmerWithMoreResourcesThanHisPlayer_true(){
        //ARRANGE
        //Setting datas for player 1
        Player player1 = new Player(1, "killer");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));
        Entity g1 = new Granary(50, 1, map2);
        Entity g2 = new Granary(50, 2, map2);
        Entity g3 = new Granary(50, 3, map2);
        Entity g4 = new Granary(50, 4, map2);
        Entity g5 = new Granary(50, 5, map2);
        Entity g6 = new Granary(50, 6, map2);
        Entity g7 = new Granary(50, 7, map2);
        Entity g8 = new Granary(50, 8, map2);
        Entity g9 = new Granary(50, 9, map2);
        Entity g10 = new Granary(50, 10, map2);
        Entity g11 = new Granary(50, 11, map2);
        player1.addEntity(g1);
        player1.addEntity(g2);
        player1.addEntity(g3);
        player1.addEntity(g4);
        player1.addEntity(g5);
        player1.addEntity(g6);
        player1.addEntity(g7);
        player1.addEntity(g8);
        player1.addEntity(g9);
        player1.addEntity(g10);
        player1.addEntity(g11);

        Farmer f1 = new Farmer(1,10, 10 );
        f1.getInventory().put(ResourceName.STONE, 60);
        f1.getInventory().put(ResourceName.WOOD, 60);
        f1.getInventory().put(ResourceName.FOOD, 60);
        player1.getEntities().add(f1);

        //setting datas for player 2
        Player player2 = new Player(2, "killed");
        Entity g21 = new Granary(50, 2, map2);
        Entity g22 = new Granary(50, 2, map2);
        Entity g23 = new Granary(50, 2, map2);
        Entity g24 = new Granary(50, 2, map2);
        Entity g25 = new Granary(50, 2, map2);
        Entity g26 = new Granary(50, 2, map2);
        Entity g27 = new Granary(50, 2, map2);
        Entity g28 = new Granary(50, 2, map2);
        Entity g29 = new Granary(50, 2, map2);
        Entity g210 = new Granary(50, 2, map2);
        Entity g211 = new Granary(50, 2, map2);
        player2.addEntity(g21);
        player2.addEntity(g22);
        player2.addEntity(g23);
        player2.addEntity(g24);
        player2.addEntity(g25);
        player2.addEntity(g26);
        player2.addEntity(g27);
        player2.addEntity(g28);
        player2.addEntity(g29);
        player2.addEntity(g210);
        player2.addEntity(g211);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        Board board = new Board();
        board.setPlayerList(playerArrayList);

        //ACT
        board.testPlunderResources(f1);

        //ASSERT
        Assert.assertEquals(0, player1.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(0, player1.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(0, player1.getResource(ResourceName.FOOD).getHp());

        Assert.assertEquals(110, player2.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(110, player2.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(110, player2.getResource(ResourceName.FOOD).getHp());
    }

    @Test
    public void plunderResources_FarmerWithLessResourcesThanHisPlayer_true(){
        //ARRANGE
        //Setting datas for player 1
        Player player1 = new Player(1, "killer");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));
        Entity g1 = new Granary(50, 1, map2);
        Entity g2 = new Granary(50, 1, map2);
        Entity g3 = new Granary(50, 1, map2);
        Entity g4 = new Granary(50, 1, map2);
        Entity g5 = new Granary(50, 1, map2);
        Entity g6 = new Granary(50, 1, map2);
        Entity g7 = new Granary(50, 1, map2);
        Entity g8 = new Granary(50, 1, map2);
        Entity g9 = new Granary(50, 1, map2);
        Entity g10 = new Granary(50,1, map2);
        Entity g11 = new Granary(50,1, map2);
        player1.addEntity(g1);
        player1.addEntity(g2);
        player1.addEntity(g3);
        player1.addEntity(g4);
        player1.addEntity(g5);
        player1.addEntity(g6);
        player1.addEntity(g7);
        player1.addEntity(g8);
        player1.addEntity(g9);
        player1.addEntity(g10);
        player1.addEntity(g11);

        Farmer f1 = new Farmer(1,10, 10 );
        f1.getInventory().put(ResourceName.STONE, 10);
        f1.getInventory().put(ResourceName.WOOD, 10);
        f1.getInventory().put(ResourceName.FOOD, 10);
        player1.getEntities().add(f1);

        //setting datas for player 2
        Player player2 = new Player(2, "killed");
        Entity g21 = new Granary(50, 2, map2);
        Entity g22 = new Granary(50, 2, map2);
        Entity g23 = new Granary(50, 2, map2);
        Entity g24 = new Granary(50, 2, map2);
        Entity g25 = new Granary(50, 2, map2);
        Entity g26 = new Granary(50, 2, map2);
        Entity g27 = new Granary(50, 2, map2);
        Entity g28 = new Granary(50, 2, map2);
        Entity g29 = new Granary(50, 2, map2);
        Entity g210 = new Granary(50,2, map2);
        Entity g211 = new Granary(50,2, map2);
        player2.addEntity(g21);
        player2.addEntity(g22);
        player2.addEntity(g23);
        player2.addEntity(g24);
        player2.addEntity(g25);
        player2.addEntity(g26);
        player2.addEntity(g27);
        player2.addEntity(g28);
        player2.addEntity(g29);
        player2.addEntity(g210);
        player2.addEntity(g211);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        Board board = new Board();
        board.setPlayerList(playerArrayList);

        //ACT
        board.testPlunderResources(f1);

        //ASSERT
        Assert.assertEquals(40, player1.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(40, player1.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(40, player1.getResource(ResourceName.FOOD).getHp());

        Assert.assertEquals(60, player2.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(60, player2.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(60, player2.getResource(ResourceName.FOOD).getHp());
    }

    @Test
    public void plunderResources_FarmerWithMoreResourcesThanTheEnemyPlayerCanHandle_true(){
        //ARRANGE
        //Setting datas for player 1
        Player player1 = new Player(1, "killer");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));
        Entity g1 = new Granary(50, 1, map2);
        Entity g2 = new Granary(50, 1, map2);
        Entity g3 = new Granary(50, 1, map2);
        Entity g4 = new Granary(50, 1, map2);
        player1.addEntity(g1);
        player1.addEntity(g2);
        player1.addEntity(g3);
        player1.addEntity(g4);

        Farmer f1 = new Farmer(1,10, 10 );
        f1.getInventory().put(ResourceName.STONE, 2000);
        f1.getInventory().put(ResourceName.WOOD, 2000);
        f1.getInventory().put(ResourceName.FOOD, 2000);
        player1.addEntity(f1);

        //setting datas for player 2
        Player player2 = new Player(2, "killed");
        Entity g21 = new Granary(50, 2, map2);
        Entity g22 = new Granary(50, 2, map2);
        Entity g23 = new Granary(50, 2, map2);
        Entity g24 = new Granary(50, 2, map2);
        player2.addEntity(g21);
        player2.addEntity(g22);
        player2.addEntity(g23);
        player2.addEntity(g24);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        Board board = new Board();
        board.setPlayerList(playerArrayList);

        //ACT
        board.testPlunderResources(f1);

        //ASSERT
        Assert.assertEquals(0, player1.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(0, player1.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(0, player1.getResource(ResourceName.FOOD).getHp());

        Assert.assertEquals(80, player2.getResource(ResourceName.STONE).getHp());
        Assert.assertEquals(80, player2.getResource(ResourceName.WOOD).getHp());
        Assert.assertEquals(80, player2.getResource(ResourceName.FOOD).getHp());
    }
}
