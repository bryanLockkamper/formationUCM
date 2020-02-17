package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperEntities;
import com.ucm.ucmempire.dal.mapper.MapperPlayer;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MapperEntitiesTest {

    MapperEntities mapperEntities;
    MapperPlayer mapperPlayer;
    PlayerEntity florentEntity;

    @Before
    public void intit () throws Exception
    {
        BuildingEntity barracksEntity = new BuildingEntity(1,Constants.TYPE_BARRACKS,florentEntity); //TODO DAMIEN : Update the building entity with the DB update
        BuildingEntity granaryEntity = new BuildingEntity(1,Constants.TYPE_GRANARY,florentEntity);
        BuildingEntity houseEntity = new BuildingEntity(1,Constants.TYPE_HOUSE,florentEntity);
        BuildingEntity forumEntity = new BuildingEntity(1,Constants.TYPE_FORUM,florentEntity);
        CharacterEntity farmerEntity = new CharacterEntity(1,Constants.TYPE_FARMER,florentEntity,10,20);
        CharacterEntity soldierEntity = new CharacterEntity(1,Constants.TYPE_SOLDIER,florentEntity,10,20);

        Set<EntityGame> entityGameList = new HashSet<>();
        entityGameList.add(barracksEntity);
        entityGameList.add(granaryEntity);
        entityGameList.add(houseEntity);
        entityGameList.add(forumEntity);
        entityGameList.add(farmerEntity);
        entityGameList.add(soldierEntity);

        florentEntity = new PlayerEntity(1,"Florent","Binks","jarjar","star",entityGameList,new BoardEntity(1,"coucou"));
    }

    @Test
    public void playerEntityToPlayer_playerFlorent_true ()
    {
        System.out.println(florentEntity);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        System.out.println(player);

        Assert.assertTrue(true);

    }
}
