package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperEntities;
import com.ucm.ucmempire.dal.mapper.MapperPlayer;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperPlayerTest {


    MapperEntities mapperEntities;
    MapperPlayer mapperPlayer;
    PlayerEntity florentEntity;
    List<EntityGame> entityGameList;
    ResourceEntity resourceEntity;

    @Before
    public void intit () throws Exception
    {
        florentEntity = new PlayerEntity();
        florentEntity.setId(1);
        florentEntity.setFirstName("Florent");
        florentEntity.setLastName("Binks");
        florentEntity.setLogin("jarjar");
        florentEntity.setPassword("star");


        mapperEntities = new MapperEntities();
        mapperPlayer = new MapperPlayer();
        BuildingEntity barracksEntity = new BuildingEntity(100, Constants.TYPE_BARRACKS,florentEntity); //TODO DAMIEN : Update the building entity with the DB update
        BuildingEntity granaryEntity = new BuildingEntity(100,Constants.TYPE_GRANARY,florentEntity);
        BuildingEntity houseEntity = new BuildingEntity(100,Constants.TYPE_HOUSE,florentEntity);
        BuildingEntity forumEntity = new BuildingEntity(100,Constants.TYPE_FORUM,florentEntity);
        CharacterEntity farmerEntity = new CharacterEntity(100,Constants.TYPE_FARMER,florentEntity,10,20,5);
        CharacterEntity soldierEntity = new CharacterEntity(100,Constants.TYPE_SOLDIER,florentEntity,10,20,5);
        resourceEntity = new ResourceEntity(100,Constants.TYPE_RESSOURCE,florentEntity,"WOOD");


        entityGameList = new ArrayList<>();
        entityGameList.add(barracksEntity);
        entityGameList.add(granaryEntity);
        entityGameList.add(houseEntity);
        entityGameList.add(forumEntity);
        entityGameList.add(farmerEntity);
        entityGameList.add(soldierEntity);
        entityGameList.add(resourceEntity);

        florentEntity.setEntityGamesList(entityGameList);

    }

    @Test
    public void playerEntityToPlayer_playerFlorent_true ()
    {
        List<Entity> entityList = entityGameList.stream()
                .filter(e -> !(e instanceof ResourceEntity))
                .map(data -> mapperEntities.entityGameToEntity(data))
                .collect(Collectors.toList());

        Set<Resource> resourceSet = new HashSet<>();
        Resource resource = new Resource(ResourceName.WOOD,100);
        resourceSet.add(resource);

        Player florian = new Player(1,"Florent",resourceSet,entityList);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        Assert.assertEquals(florian,player);

    }

    @Test
    public void playerEntityToPlayer_playerAlex_false ()
    {
        List<Entity> entityList = entityGameList.stream()
                .filter(e -> !(e instanceof ResourceEntity))
                .map(data -> mapperEntities.entityGameToEntity(data))
                .collect(Collectors.toList());

        Set<Resource> resourceSet = new HashSet<>();
        Resource resource = new Resource(ResourceName.WOOD,100);
        resourceSet.add(resource);

        Player Alex = new Player(2,"Alex",null,null);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        Assert.assertNotEquals(Alex,player);

    }

    @Test (expected = NullPointerException.class)
    public void playerEntityToPlayer_null_NullPointerException ()
    {
        Player player = mapperPlayer.playerEntityToPlayer(null);
    }

    @Test
    public void playerEntityToPlayer_playerFlorentWithOtherEntities_false ()
    {
        List<Entity> entityList = entityGameList.stream()
                .filter(e -> !(e instanceof ResourceEntity))
                .filter(a -> !(a.getType().equals(Constants.TYPE_GRANARY)))
                .map(data -> mapperEntities.entityGameToEntity(data))
                .collect(Collectors.toList());

        Set<Resource> resourceSet = new HashSet<>();
        Resource resource = new Resource(ResourceName.WOOD,100);
        resourceSet.add(resource);

        Player florian = new Player(1,"Florent",resourceSet,entityList);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        Assert.assertNotEquals(florian,player);

    }

    @Test
    public void playerEntityToPlayer_playerFlorentWithoutEntities_true ()
    {
        florentEntity.setEntityGamesList(null);

        Player florian = new Player(1,"Florent",null,null);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        Assert.assertEquals(florian,player);
    }

    @Test
    public void playerEntityToPlayer_playerFlorentWithOnlyRessourceEntity_true ()
    {

        florentEntity.getEntityGamesList().clear();
        florentEntity.getEntityGamesList().add(resourceEntity);
        Set<Resource> resourceSet = new HashSet<>();
        Resource resource = new Resource(ResourceName.WOOD,100);
        resourceSet.add(resource);

        Player florian = new Player(1,"Florent",resourceSet,null);
        Player player = mapperPlayer.playerEntityToPlayer(florentEntity);

        Assert.assertEquals(florian,player);
    }
}
