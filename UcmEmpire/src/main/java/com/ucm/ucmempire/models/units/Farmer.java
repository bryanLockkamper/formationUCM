package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.unitInterfaces.IFarmer;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@ToString
@EqualsAndHashCode(callSuper = true)
public class Farmer extends Character implements IFarmer {

    private ResourceName resourceHarvesting;
    private HashSet<Resource> requirement;
    private Map<ResourceName, Integer> inventory; //TODO NEED TO ADD TO THE ENTITY AND IN THE MAPPER


    public Farmer(int idUser) {
        super(idUser, Constants.NB_POINTDEVIE, Constants.NB_POINTACTION);
        setInventory();
        requirement = new HashSet<>();
        requirement.add(new Resource(ResourceName.FOOD, 20));
    }

    public Farmer(ResourceName resourceHarvesting, Map<ResourceName, Integer> inventory) {
        this.resourceHarvesting = resourceHarvesting;
        this.inventory = inventory;
    }

    public Farmer(Integer idUser, int hp, int pa, ResourceName resourceHarvesting) {
        super(idUser, hp, pa);
        this.resourceHarvesting = resourceHarvesting;
    }

    public Farmer(Integer idUser, int hp, int pa, ResourceName resourceHarvesting, Map<ResourceName, Integer> inventory) {
        super(idUser, hp, pa);
        this.resourceHarvesting = resourceHarvesting;
        this.inventory = inventory;
    }

    public Farmer(EntityDTO entityDTO, ResourceName resourceHarvesting, Map<ResourceName, Integer> inventory) {
        super(entityDTO);
        this.resourceHarvesting = resourceHarvesting;
        this.inventory = inventory;
    }

    public Farmer (EntityDTO entityDTO)
    {
        super(entityDTO.getIdPlayer(),entityDTO.getHp(),entityDTO.getPa());
        this.resourceHarvesting = ResourceName.valueOf(entityDTO.getTypeRessource());

    }
    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.

    public Farmer(Integer idUser, int hp, int pa) {
        super(idUser, hp, pa);
        this.setInventory();
    }

    public void move(ResourceName resourceName) {
        this.pa--;
        resourceHarvesting = resourceName;
    }

    public ResourceName getResourceHarvesting(){
        return resourceHarvesting;
    }

    public void setResourceHarvesting(ResourceName resourceHarvesting){
        this.resourceHarvesting = resourceHarvesting;
    }

    public Map<ResourceName, Integer> getInventory() {
        return this.inventory;
    }


    private void setInventory(){
        this.inventory = new HashMap<>();
        this.inventory.put(ResourceName.STONE, 0);
        this.inventory.put(ResourceName.FOOD, 0);
        this.inventory.put(ResourceName.WOOD, 0);
    }

    public Resource getRequirement(ResourceName resourceName){
        return requirement.stream()
                .filter(resource -> resource.getResourceName().equals(resourceName))
                .findFirst().orElse(null);
    }

    public void setRequirement(HashSet<Resource> requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "resourceHarvesting=" + resourceHarvesting +
                ", pa=" + pa +
                ", moveLeft=" + moveLeft +
                ", hp=" + hp +
                "} " + super.toString();
    }
}
