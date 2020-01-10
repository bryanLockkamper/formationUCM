package models.buildings;

import models.Entity;
import models.buildings.buildingInterfaces.IBarracks;
import models.ressources.RessourceName;

import java.util.HashMap;
import java.util.List;

public class Barracks extends ProdBuilding implements IBarracks {

    public Barracks(int hp, String name, HashMap<RessourceName, Integer> requirement) {
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
