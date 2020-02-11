package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IForum;
import com.ucm.ucmempire.models.resources.Resource;

import java.util.HashSet;
import java.util.List;

public class Forum extends ProdBuilding implements IForum {

    private List<Entity> entities;

    public Forum(int hp, Integer id, HashSet<Resource> requirement) {
        super(hp, id, requirement);
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public Entity decrementCounter() {
        return null;
    }


}
