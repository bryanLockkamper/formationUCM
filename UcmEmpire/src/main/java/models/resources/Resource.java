package models.resources;

import models.Entity;

public class Resource extends Entity implements IResource{
    private ResourceName resourceName;
    public Resource(ResourceName resourceName) {
        super(Integer.MAX_VALUE, resourceName.getType());
        this.resourceName = resourceName;
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
