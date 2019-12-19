package models.resources;

public interface IResource { //TODO: link with player 
    int getRessource(ResourceName resourceName);
    boolean addRessource(int nbRessourceAAjouter, ResourceName resourceName);
}
