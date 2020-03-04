package com.ucm.ucmempire;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.buildings.Barracks;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

public class ProdBuildingTest {

    @Test
    public void prodBuilding_NormalCase_True(){

        //Arrange
        Player player1 = new Player(1, "Toto");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        Forum forum = new Forum(100 ,1 ,map2);
        ArrayList<Entity> list = new ArrayList<>();
        list.add(forum);
        player1.setEntities(list);

        //Act
        Entity entity = forum.getUnit(1);

        //Assert
        assertTrue(entity instanceof Farmer);

    }

    @Test
    public void prodBuilding_WrongId_Exception(){

        //Arrange
        Player player1 = new Player(1, "Toto");
        HashSet<Resource> map2 = new HashSet<>();

        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        Forum forum = new Forum(100 ,2 ,map2);

        Assert.assertFalse(player1.addEntity(forum));


    }
}
