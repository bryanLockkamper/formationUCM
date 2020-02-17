package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.unitInterfaces.IFarmer;

public class Farmer extends Character implements IFarmer {

    private ResourceName resourceHarvesting;

//    public Farmer(int pv, Integer name, int pa) {
//        super(pv, name, pa);
//    }

    public Farmer(int idUser) {
        this.hp = Constants.NB_POINTDEVIE;
        this.pa = Constants.NB_POINTACTION;
    }

    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.

    public Farmer(Integer idUser, int hp, int pa) {
        super(idUser, hp, pa);
    }

//    @Override
//    public String toString() {
//        return "Farmer{" +
//                "resourceHarvesting=" + resourceHarvesting +
//                ", pa=" + pa +
//                ", moveLeft=" + moveLeft +
//                ", hp=" + hp +
//                '}';
//    }

    public ResourceName getResourceHarvesting(){
        return resourceHarvesting;
    }

    public void setResourceHarvesting(ResourceName resourceHarvesting){
        this.resourceHarvesting = resourceHarvesting;
    }
}
