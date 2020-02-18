package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.buildings.Granary;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IProdBuilding;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.EqualsAndHashCode;

import java.util.*;
@EqualsAndHashCode
public class Player {
    private final int granarySize = 20;

    private int id;
    protected String name;
    protected Set<Resource> resources;
    protected List<Entity> entities;

    public Player(int id, String name, Set<Resource> resources, List<Entity> entities) {
        this.id = id;
        this.name = name;
        this.resources = resources;
        this.entities = entities;
    }

    public Player(){
        resources = new HashSet<>();
        resources.add(new Resource(ResourceName.WOOD));
        resources.add(new Resource(ResourceName.STONE));
        resources.add(new Resource(ResourceName.FOOD));

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
    } //TODO BRYAN : add condition for the victory

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


    public void maxPa() {
        for (Entity entity : entities) {
            if (entity instanceof Character)
                ((Character) entity).setMaxPA();
        }
    }

    public Entity getEntity(int i) {
        return entities.get(i);
    }

    public void addEntity(Entity content) {
        entities.add(content);
    }

    public int getGranarySize() {
        return granarySize;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
