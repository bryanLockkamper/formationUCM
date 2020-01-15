package models.resources;

import models.units.IEntity;

public interface IResource extends IEntity { //TODO: link with player
    int getRessource(ResourceName resourceName);
    boolean addRessource(int nbRessourceAAjouter, ResourceName resourceName);
}
