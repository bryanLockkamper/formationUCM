package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.unitInterfaces.IFarmer;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ToString
public class Farmer extends Character implements IFarmer {

    private ResourceName resourceHarvesting;

    private Map<ResourceName, Integer> inventory;


    public Farmer(int idUser) {
        super(idUser, Constants.NB_POINTDEVIE, Constants.NB_POINTACTION);
    }

    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.

    public Farmer(Integer idUser, int hp, int pa) {
        super(idUser, hp, pa);
        this.setInventory();
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
}
