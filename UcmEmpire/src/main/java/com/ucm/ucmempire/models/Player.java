package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.buildings.Granary;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IProdBuilding;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Player {
    private final int granarySize = 20;
    protected String name;
    protected HashSet<Resource> resources;
    protected List<Entity> entities;

    public Player(){
        resources = new HashSet<>();
        resources.add(new Resource(ResourceName.WOOD, 0));
        resources.add(new Resource(ResourceName.STONE, 0));
        resources.add(new Resource(ResourceName.FOOD, 0));

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

            return Objects.requireNonNull(resources.stream()
                    .filter(resource -> resource.getResourceName().equals(resourceName))
                    .findFirst().orElse(null)).hp;

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

//    public void autoHarvestResources() {
//        for (Entity entity : entities) {
//            if (entity instanceof IFarmer)
//                resources.add(new Resource(((Farmer)entity).getResourceHarvesting(),((Farmer)entity).harvest()));
//        }
//    }

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

    public int getGranarySize() {
        return granarySize;
    }

    public HashSet<Resource> getResources() {
        return resources;
    }

    public void setResources(HashSet<Resource> resources) {
        this.resources = resources;
    }
}