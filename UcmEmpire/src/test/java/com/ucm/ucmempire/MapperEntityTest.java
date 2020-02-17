package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperEntity;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapperEntityTest {

    MapperEntity mapper;
    PlayerEntity florentEntity;

    @Before
    public void intit () throws Exception
    {
        BuildingEntity barracksEntity = new BuildingEntity(1,100,Constants.TYPE_BARRACKS); //TODO DAMIEN : Update the building entity with the DB update
        BuildingEntity granaryEntity = new BuildingEntity(1,100,Constants.TYPE_GRANARY);
        BuildingEntity houseEntity = new BuildingEntity(1,100,Constants.TYPE_HOUSE);
        BuildingEntity forumEntity = new BuildingEntity(1,100,Constants.TYPE_FORUM);
        CharacterEntity farmerEntity = new CharacterEntity(1,100,Constants.TYPE_FARMER,10,20);
        CharacterEntity soldierEntity = new CharacterEntity(1,100,Constants.TYPE_SOLDIER,10,20);

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
        Player player = mapper.playerEntityToPlayer(florentEntity);

        System.out.println(player);

        Assert.assertTrue(true);

    }
}
