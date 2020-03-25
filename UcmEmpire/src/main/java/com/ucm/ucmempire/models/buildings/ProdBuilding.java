package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IProdBuilding;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IBarracks;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IForum;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class ProdBuilding extends Building implements IProdBuilding {

    public static final int FARMER_ENTITY =1;
    public static final int SOLDIER_ENTITY =2;

    private List<Entity> prod;
    private List<Entity> entities;

    public ProdBuilding(int pv, Integer id, HashSet<Resource> requirement) {
        super(pv, id, requirement);
        prod = new ArrayList<>();
        entities = new ArrayList<>();
    }

    public Entity getUnit(int prodType){
        Character character = null;

        if (this instanceof IForum)
        {
            if (prodType == FARMER_ENTITY) {
                System.out.println(this.getIdUser());
                character = new Farmer(this.getIdUser());
            } else {
                throw new IllegalArgumentException("Incorrect type");
            }

        }
         else if (this instanceof IBarracks)
        {
            if (prodType == SOLDIER_ENTITY) {
                character = new Soldier(this.getIdUser());
            } else {
                throw new IllegalArgumentException("Incorrect type");
            }
        }

        return character;
    }

    @Override
    public Integer decrementCounter() {
        return 0;
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.prod = entities;
    }

    public void product(Entity entity) {
        prod.add(entity);
    }

    public List<Entity> getProd() {
        return prod;
    }

    public void setProd(List<Entity> prod) {
        this.prod = prod;
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
