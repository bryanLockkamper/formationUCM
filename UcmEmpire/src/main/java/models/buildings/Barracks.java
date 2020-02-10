package models.buildings;

import models.Entity;
import models.buildings.buildingInterfaces.IBarracks;
import models.resources.Resource;
import models.resources.ResourceName;

import java.util.HashMap;
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
