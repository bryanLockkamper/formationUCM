package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IBarracks;
import com.ucm.ucmempire.models.resources.Resource;

import java.util.HashSet;
import java.util.List;

public class Barracks extends ProdBuilding implements IBarracks {

    public Barracks(int hp, Integer name, HashSet<Resource> requirement) {
        super(hp, name, requirement);
    }

    @Override
    public void setEntities(List<Entity> entities) {

    }

    @Override
    public Entity decrementCounter() {
        return null;
    }
}
