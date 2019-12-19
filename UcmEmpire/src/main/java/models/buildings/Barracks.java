package models.buildings;

import models.Entity;
import models.resources.Resource;
import models.buildings.buildingInterfaces.IBarracks;

import java.util.List;

public class Barracks extends ProdBuilding implements IBarracks {

    public Barracks(int hp, String name, List<Resource> requirement) {
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
