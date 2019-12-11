package models.batiments.BatimentInterfaces;

import models.Entity;

import java.util.List;

public interface IBatimentProd {

    List<Entity> getEntities();

    void setEntities(List<Entity> entities);


    Entity decrementCompteur();
}
