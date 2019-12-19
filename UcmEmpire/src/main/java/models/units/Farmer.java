package models.units;

import models.Character;
import models.resources.ResourceName;
import models.units.unitInterfaces.IFarmer;

public class Farmer extends Character implements IFarmer {

    private ResourceName resourceHarvesting;

    public Farmer(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int harvest() {
        int harvest = getPa();
        setPa(0);
        return harvest;
    }

    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.

    @Override
    public String toString() {
        return "F";
    }

    public ResourceName getResourceHarvesting(){
        return resourceHarvesting;
    }

    public void setResourceHarvesting(ResourceName resourceHarvesting){
        this.resourceHarvesting = resourceHarvesting;
    }
}
