package models.batiments;

import models.Entity;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IMaison;

import java.util.List;

public class Maison extends Batiment implements IMaison {
    public Maison(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
    }
}
