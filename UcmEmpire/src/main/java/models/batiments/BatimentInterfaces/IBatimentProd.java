package models.batiments.BatimentInterfaces;

import models.Entity;

import java.util.List;

public interface IBatimentProd {

    List<Entity> getEntities();
    Entity decrementCompteur();

    void setEntities(List<Entity> entities);
}
