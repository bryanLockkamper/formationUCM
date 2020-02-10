package models.resources;

import models.Entity;

public class Resource extends Entity implements IResource{
    private ResourceName resourceName;

    public Resource(ResourceName resourceName) {
        this(resourceName, Integer.MAX_VALUE);
    }

    public Resource(ResourceName resourceName, Integer nb) {
        this.resourceName = resourceName;
        this.hp = nb;
    }

    @Override
    public int getRessource(ResourceName resourceName) {
        return 0;
    }

    @Override
    public boolean addRessource(int nbRessourceAAjouter, ResourceName resourceName) {
        return false;
    }

    public ResourceName getResourceName() {
        return resourceName;
    }

    public void setResourceName(ResourceName resourceName) {
        this.resourceName = resourceName;
    }
}
