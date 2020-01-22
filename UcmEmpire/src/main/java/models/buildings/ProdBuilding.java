package models.buildings;

import models.Entity;
import models.Character;
import models.buildings.buildingInterfaces.IProdBuilding;
import models.buildings.buildingInterfaces.IBarracks;
import models.buildings.buildingInterfaces.IForum;
import models.resources.Resource;
import models.resources.ResourceName;
import models.units.Builder;
import models.units.Farmer;
import models.units.Soldier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class ProdBuilding extends Building implements IProdBuilding {

    public static final int FARMER_ENTITY =1;
    public static final int BUILDER_ENTITY =2;
    public static final int SOLDIER_ENTITY =3;

    private int compteur;
    private List<Entity> prod;

    public ProdBuilding(int pv, String name, HashSet<Resource> requirement) {
        super(pv, name, requirement);
        prod = new ArrayList<>();
    }

    public Entity getUnit(int prodType){
        Character character = null;

        if (this instanceof IForum)
        {
            switch (prodType){
                case FARMER_ENTITY:
                    character = new Farmer( 10 , "Guetno" , 10);
                    break;
                case BUILDER_ENTITY:
                    character = new Builder(10 , "Builder" , 10);
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect type");
            }

        }
         else if (this instanceof IBarracks)
        {
            switch (prodType)
            {
                case SOLDIER_ENTITY:
                    character = new Soldier(15 , "Perceval" , 10);
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect type");
            }
        }

        return character;
    }

    @Override
    public List<Entity> getEntities() {
        return prod;
    }

    @Override
    public Entity decrementCounter() {
        return null;
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.prod = entities;
    }

}
