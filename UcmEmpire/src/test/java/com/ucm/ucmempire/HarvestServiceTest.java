package com.ucm.ucmempire;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import org.junit.Test;
import com.ucm.ucmempire.services.HarvestService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HarvestServiceTest {

    HarvestService harvestService = new HarvestService();

    @Test
    public void harvestNormalCase_true(){

        //Arrange
        Player p1 = new Player();
        Farmer f1 = new Farmer(10,1, 10 );
        Farmer f2 = new Farmer(10,2, 10 );
        Farmer f3 = new Farmer(10,3, 10 );
        SpecialSquare square = new SpecialSquare(ResourceName.STONE);
        square.setResourceQuantity(Integer.MAX_VALUE);
        List<Entity> list = new ArrayList<>();

        list.add(f1);
        list.add(f2);
        list.add(f3);
        p1.setEntities(list);
        //Act
        Integer nb = harvestService.autoHarvestResources(square,p1);

        //Assert
        assertEquals(10, (int)nb);
    }

}