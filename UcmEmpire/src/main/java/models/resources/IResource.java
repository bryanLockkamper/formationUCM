package models.resources;

public interface IResource {
    int getRessource(ResourceName resourceName);
    boolean addRessource(int nbRessourceAAjouter, ResourceName resourceName);
}
