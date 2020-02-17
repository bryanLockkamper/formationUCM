package com.ucm.ucmempire.models.resources;

import com.ucm.ucmempire.models.Entity;

public class Resource extends Entity implements IResource{
    private ResourceName resourceName;

    public Resource(ResourceName resourceName) {
        this.resourceName = resourceName;
        this.hp = resourceName.getQuantity();
    }

    public Resource(ResourceName resourceName, int quantity) {
        this(resourceName);
        this.hp = quantity;
    }


    @Override
    public int getRessource(ResourceName resourceName) {
        return resourceName.getQuantity();
    }


    public ResourceName getResourceName() {
        return resourceName;
    }

}
