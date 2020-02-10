package models;

import models.buildings.Granary;
import models.resources.ResourceName;
import java.util.ArrayList;
import java.util.HashMap;
import models.buildings.buildingInterfaces.IProdBuilding;
import models.units.Farmer;
import models.units.unitInterfaces.IFarmer;
import java.util.List;
import java.util.Map;

public class Player {
    private final int granarySize = 20;
    protected String name;
    protected Map<ResourceName, Integer> resources;
    protected List<Entity> entities;

    public Player(){
        resources = new HashMap<>();
        resources.put(ResourceName.WOOD, 0);
        resources.put(ResourceName.STONE, 0);
        resources.put(ResourceName.FOOD, 0);

        entities = new ArrayList<>();
    }

    public int getMaxResources(){
        int nbGranaries = 0;
        for (int i = 0; i < entities.size() ; i++) {
            if(entities.get(i) instanceof Granary){
                nbGranaries++;
            }
        }

        return nbGranaries*granarySize;
    }

    public int getResources(ResourceName resourceName){
            return resources.get(resourceName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public boolean hasLost() {
        return true;
    }

    public void autoMoveUnits() {
        for (Entity entity : entities) {
            if (entity instanceof Character)
                ((Character) entity).autoMove();
        }
    }

    public void buildEntity() {
        for (Entity entity : entities) {
            if (entity instanceof IProdBuilding)
                if (((IProdBuilding) entity).decrementCounter() != null)
                    entities.add(entity);
        }
    }

    public void autoHarvestResources() {
        for (Entity entity : entities) {
            if (entity instanceof IFarmer)
                resources.put(((Farmer)entity).getResourceHarvesting(),((Farmer)entity).harvest());
        }
    }

    public void maxPa() {
        for (Entity entity : entities) {
            if (entity instanceof Character)
                ((Character)entity).setMaxPA();
        }
    }

    public Entity getEntity(int i) {
        return entities.get(i);
    }

    public void addEntity(Entity content) {
    }
}
