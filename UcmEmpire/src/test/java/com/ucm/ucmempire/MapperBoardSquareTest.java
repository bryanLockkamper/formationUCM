package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperEntities;
import com.ucm.ucmempire.models.Constants;
import org.junit.Before;

public class MapperBoardSquareTest {

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
        florentEntity = new PlayerEntity(1,"Florent","Binks","jarjar","star",null,new BoardEntity(1,"coucou"));


        barracksEntity = new BuildingEntity(100, Constants.TYPE_BARRACKS,florentEntity); //TODO DAMIEN : Update the building entity with the DB update
        granaryEntity = new BuildingEntity(100,Constants.TYPE_GRANARY,florentEntity);
        houseEntity = new BuildingEntity(100,Constants.TYPE_HOUSE,florentEntity);
        forumEntity = new BuildingEntity(100,Constants.TYPE_FORUM,florentEntity);
        farmerEntity = new CharacterEntity(100,Constants.TYPE_FARMER,florentEntity,10,20,null);
        soldierEntity = new CharacterEntity(100,Constants.TYPE_SOLDIER,florentEntity,10,20,5);

        resourceEntity = new ResourceEntity(100,Constants.TYPE_RESSOURCE,florentEntity,"WOOD");
    }


}
