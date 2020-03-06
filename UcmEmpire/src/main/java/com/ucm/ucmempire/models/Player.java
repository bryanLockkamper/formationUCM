package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.buildings.Building;
import com.ucm.ucmempire.models.buildings.Granary;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IProdBuilding;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import lombok.EqualsAndHashCode;

import java.util.*;
@EqualsAndHashCode
public class Player {
    private int id;
    private final int granarySize = 50;
    private String name;
    private Set<Resource> resources;
    private List<Entity> entities;
    private boolean hasLost;

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

        entities = initEntitiesPlayer();
        hasLost = false;
    }

    public Player(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxResources(){
        int nbGranaries = 0;
        for (Entity entity : entities) {
            if (entity instanceof Granary) {
                nbGranaries++;
            }
        }

        return nbGranaries*granarySize;
    }

    public Resource getResource(ResourceName resourceName){
        return resources.stream()
                .filter(resource -> resource.getResourceName().equals(resourceName))
                .findFirst().orElse(null);
    }

    public int getResources(ResourceName resourceName){

        return Objects.requireNonNull(resources.stream()
                .filter(resource -> resource.getResourceName().equals(resourceName))
                .findFirst().orElse(null)).hp;

    }

    public Set<Resource> getResources() {
        return resources;
    }

    public List<Entity> initEntitiesPlayer()
    {
        List<Entity> firstListEntities = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            firstListEntities.add(new Granary(Constants.NB_POINTDEVIE,this.id,null));
        }
        return firstListEntities;
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

    public boolean isHasLost() {
        return hasLost;
    }

    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
    }

    public void suicideUnit(Entity entity){
        this.entities.remove(entity);
    }

    public void setMaxResources(){
        resources.forEach(r -> r.setMaxHP(getMaxResources()));
    }

    public void removeInventaryResourcesFromPlayerResources(Farmer farmer){
        for (ResourceName name:farmer.getInventory().keySet()) {
            Resource playerResource = this.getResource(name);
            playerResource.setHp(playerResource.getHp()-farmer.getInventory().get(name));
        }
    }

    public boolean giveUp(){
        this.hasLost = true;
        return hasLost;
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

    public boolean addEntity(Entity content) {
        //Si mon entité est bien une instace de Character ou de Building
        if((content instanceof Character && ((Character)content).getIdUser() == this.getId() )
                || content instanceof Building && ((Building)content).getIdUser() == this.getId()){
            //Et si l'idUser de l'entité correspond a celui de mon User
            // TODO: 19-02-20 ALEXANDRE c'est quoi ça?
            /*if ( ((Character)content).getIdUser() == this.getId() || ((Building)content).getIdUser() == this.getId())
            {*/
                //Alors je rajoute a la liste d'entités
                entities.add(content);
                if(content instanceof Granary){
                    setMaxResources();
                }

            //}
        return true;
        } else return false;

    }

    public int getGranarySize() {
        return granarySize;
    }


    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public int getActualQuantityTotalRessources()
    {
        int total = 0;
        for (Resource re: this.resources) {
            total += re.getHp();
        }
        return total;
    }


    @Override
    public String toString() {
        return "Player{" +
                "granarySize=" + granarySize +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", resources=" + resources +
                ", entities=" + entities +
                '}';
    }
}
