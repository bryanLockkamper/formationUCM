package models.unite;

import models.Personnage;
import models.ressources.RessourceName;
import models.unite.UnitInterface.IPaysan;

public class Paysan extends Personnage implements IPaysan {

    private RessourceName ressourceARecolter;

    public Paysan(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int recolter() {
        int recolte = getPa();
        setPa(0);
        return recolte;
    }

    //TODO : override "move()" pour que si on tombe sur une case de ressources, on modifie l'attribut "ressourceARecolter" s'il y a un attribut.

    @Override
    public String toString() {
        return "P";
    }

    public RessourceName getRessourceARecolter(){
        return ressourceARecolter;
    }
}
