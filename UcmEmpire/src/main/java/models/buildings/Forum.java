package models.buildings;

import models.Entity;
import models.buildings.buildingInterfaces.IForum;
import models.resources.ResourceName;

import java.util.HashMap;
import java.util.List;

public class Forum extends ProdBuilding implements IForum {

    private List<Entity> entities;

    public Forum(int hp, Integer name, HashMap<ResourceName, Integer> requirement) {
        super(hp, name, requirement);
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
