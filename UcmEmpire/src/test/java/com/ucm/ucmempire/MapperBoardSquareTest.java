package com.ucm.ucmempire;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.dal.mapper.MapperBoardSquare;
import com.ucm.ucmempire.dal.mapper.MapperEntities;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.House;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MapperBoardSquareTest {

    MapperBoardSquare mapperBoardSquare;
    CharacterEntity farmerEntity;
    CharacterEntity soldierEntity;
    BuildingEntity barracksEntity;
    BuildingEntity granaryEntity;
    BuildingEntity houseEntity;
    BuildingEntity forumEntity;
    ResourceEntity resourceEntity;
    PlayerEntity florentEntity;
    SquareEntity squareEntity;
    SquareEntity specialSquareEntity;

    List<SquareContent> squareContentList;

    @Before
    public void intit () throws Exception
    {
        mapperBoardSquare = new MapperBoardSquare();
        squareContentList = new ArrayList<>();
        florentEntity = new PlayerEntity(1,"Florent","Binks","jarjar","star",null,new BoardEntity("coucou"));


        barracksEntity = new BuildingEntity(100, Constants.TYPE_BARRACKS,florentEntity); //TODO DAMIEN : Update the building entity with the DB update
        granaryEntity = new BuildingEntity(100,Constants.TYPE_GRANARY,florentEntity);
        houseEntity = new BuildingEntity(100,Constants.TYPE_HOUSE,florentEntity);
        forumEntity = new BuildingEntity(100,Constants.TYPE_FORUM,florentEntity);
        farmerEntity = new CharacterEntity(100,Constants.TYPE_FARMER,florentEntity,10,20,null);
        soldierEntity = new CharacterEntity(100,Constants.TYPE_SOLDIER,florentEntity,10,20,5);

        resourceEntity = new ResourceEntity(100,Constants.TYPE_RESSOURCE,florentEntity,"STONE");
        squareEntity = new SquareEntity(1,true,true,false,"PLAINS","0:0",null);

        specialSquareEntity = new SquareEntity(1,true,false,true,"PLAINS","0:0",new ArrayList<SquareContent>());

    }

    @Test
    public void squareEntityToSquare_noEntity_true ()
    {
        Square simpleSquare = new Square(null,true,true, BiomeType.PLAINS);

        Square square = mapperBoardSquare.squareEntityToSquare(squareEntity);

        Assert.assertEquals(simpleSquare,square);

    }

    @Test
    public void squareEntityToSquare_WithSoldier_true ()
    {
        Square simpleSquare = new Square(new Soldier(100,1,10,5),false,false, BiomeType.PLAINS);

        SquareContent squareContent = new SquareContent(squareEntity,soldierEntity,null);
        squareContentList.add(squareContent);
        squareEntity.setContents(squareContentList);
        squareEntity.setBuildable(false);
        squareEntity.setWalkable(false);
        Square square = mapperBoardSquare.squareEntityToSquare(squareEntity);

        Assert.assertEquals(simpleSquare,square);
    }

    @Test
    public void squareEntityToSquare_WithHouse_true ()
    {
        Square simpleSquare = new Square(new House(100,1,null),false,false, BiomeType.PLAINS);

        SquareContent squareContent = new SquareContent(squareEntity,houseEntity,null);
        squareContentList.add(squareContent);
        squareEntity.setContents(squareContentList);
        squareEntity.setBuildable(false);
        squareEntity.setWalkable(false);
        Square square = mapperBoardSquare.squareEntityToSquare(squareEntity);

        Assert.assertEquals(simpleSquare,square);
    }

    @Test
    public void squareEntityToSpecialSquare_StoneWith2Farmers_true ()
    {
        List<Farmer> farmers = new ArrayList<>();
        farmers.add(new Farmer(1,100,10,ResourceName.STONE));
        farmers.add(new Farmer(1,50,10,ResourceName.STONE));

        SpecialSquare specialSquare = new SpecialSquare(new Resource(ResourceName.STONE,50),BiomeType.PLAINS,farmers);

        squareEntity.setBuildable(false);
        squareEntity.setWalkable(true);
        squareEntity.setSpecial(true);
        //TODO DAMIEN : prob avec ressources
        CharacterEntity farmerEntity2 = new CharacterEntity(100,Constants.TYPE_FARMER,florentEntity,10,20,null);

        SquareContent squareContent = new SquareContent(squareEntity,farmerEntity,50);
        SquareContent ressourceContent = new SquareContent(squareEntity,resourceEntity,50);
        specialSquareEntity.getContents().add(squareContent);
        specialSquareEntity.getContents().add(new SquareContent(squareEntity,farmerEntity2,50));
        specialSquareEntity.getContents().add(ressourceContent);
//TODO DAMIEN : add a farmerEntity2 ?
        squareContentList.add(squareContent);
        squareContentList.add(ressourceContent);
        squareEntity.setContents(squareContentList);

        Square square =mapperBoardSquare.squareEntityToSquare(squareEntity);
        specialSquare.getFarmers().stream().forEach(data -> System.out.println(data.toString()));
        System.out.println("##############");
        ((SpecialSquare) square).getFarmers().stream().forEach(data -> System.out.println(data.toString()));

        Assert.assertEquals(specialSquare,square);
    }




}
