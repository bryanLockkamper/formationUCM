package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.unitInterfaces.IFarmer;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Farmer extends Character implements IFarmer {

    private ResourceName resourceHarvesting;

    public Farmer(Integer idUser, int hp, int pa) {
        super(idUser, hp, pa);
    }

    public Farmer(Integer idUser, int hp, int pa, ResourceName resourceHarvesting) {
        this(idUser, hp, pa);
        this.resourceHarvesting = resourceHarvesting;
    }
    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.



    public ResourceName getResourceHarvesting(){
        return resourceHarvesting;
    }

    public void setResourceHarvesting(ResourceName resourceHarvesting){
        this.resourceHarvesting = resourceHarvesting;
    }
}
