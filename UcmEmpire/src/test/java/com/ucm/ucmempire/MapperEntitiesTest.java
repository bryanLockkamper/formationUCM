package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperEntities;
import com.ucm.ucmempire.dal.mapper.MapperPlayer;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.buildings.Barracks;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.buildings.Granary;
import com.ucm.ucmempire.models.buildings.House;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MapperEntitiesTest {

    MapperEntities mapperEntities;
    CharacterEntity farmerEntity;
    CharacterEntity soldierEntity;
    BuildingEntity barracksEntity;
    BuildingEntity granaryEntity;
    BuildingEntity houseEntity;
    BuildingEntity forumEntity;
    ResourceEntity resourceEntity;
    PlayerEntity florentEntity;

    @Before
    public void intit () throws Exception
    {
        mapperEntities = new MapperEntities();
        florentEntity = new PlayerEntity("Binks","Florent","jarjar","star",1,new BoardEntity("coucou"),null);


        barracksEntity = new BuildingEntity(100,Constants.TYPE_BARRACKS,florentEntity); //TODO DAMIEN : Update the building entity with the DB update
         granaryEntity = new BuildingEntity(100,Constants.TYPE_GRANARY,florentEntity);
         houseEntity = new BuildingEntity(100,Constants.TYPE_HOUSE,florentEntity);
         forumEntity = new BuildingEntity(100,Constants.TYPE_FORUM,florentEntity);
        farmerEntity = new CharacterEntity(100,Constants.TYPE_FARMER,florentEntity,10,20,null);
        soldierEntity = new CharacterEntity(100,Constants.TYPE_SOLDIER,florentEntity,10,20,5);

        resourceEntity = new ResourceEntity(100,Constants.TYPE_RESSOURCE,florentEntity,"WOOD");
    }

    @Test
    public void entityGameToEntity_farmerEntity_true ()
    {

        Farmer farmer = new Farmer(1,100,10);
        Entity entity =(mapperEntities.entityGameToEntity(farmerEntity));

        Assert.assertEquals(farmer,entity);

    }

    @Test
    public void entityGameToEntity_soldierEntity_true ()
    {

        Soldier soldier = new Soldier(100,1,10,5);
        Entity entity = (mapperEntities.entityGameToEntity(soldierEntity));

        Assert.assertEquals(soldier,entity);

    }

    @Test
    public void entityGameToEntity_barrackEntity_true ()
    {
        Barracks barracks = new Barracks(100,1,null); //TODO DAMIEN : Update the building entity with the DB update
        Entity entity = (mapperEntities.entityGameToEntity(barracksEntity));
        Assert.assertEquals(barracks,entity);
    }

    @Test
    public void entityGameToEntity_forumEntity_true ()
    {
        Forum forum = new Forum(100,1,null); //TODO DAMIEN : Update the building entity with the DB update
        Entity entity = (mapperEntities.entityGameToEntity(forumEntity));
        Assert.assertEquals(forum,entity);
    }

    @Test
    public void entityGameToEntity_houseEntity_true ()
    {
        House house = new House(100,1,null); //TODO DAMIEN : Update the building entity with the DB update
        Entity entity = (mapperEntities.entityGameToEntity(houseEntity));
        Assert.assertEquals(house,entity);
    }

    @Test
    public void entityGameToEntity_granaryEntity_true ()
    {
        Granary granary = new Granary(100,1,null); //TODO DAMIEN : Update the building entity with the DB update
        Entity entity = (mapperEntities.entityGameToEntity(granaryEntity));
        Assert.assertEquals(granary,entity);
    }

    @Test
    public void entityGameToEntity_ressourceEntity_true ()
    {
        Resource resource = new Resource(ResourceName.WOOD,100);
        Entity entity = (mapperEntities.entityGameToEntity(resourceEntity));
        Assert.assertEquals(resource,entity);
    }


    @Test
    public void entityGameToEntity_houseEntityToSoldier_false ()
    {
        Soldier soldier = new Soldier(100,1,10,5);
        Entity entity = (mapperEntities.entityGameToEntity(houseEntity));
        Assert.assertNotEquals(soldier,entity);
    }

    @Test
    public void entityGameToEntity_null_MappingException ()
    {
        Assert.assertNull(mapperEntities.entityGameToEntity(null));
    }


}
