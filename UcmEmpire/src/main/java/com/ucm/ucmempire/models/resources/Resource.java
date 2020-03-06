package com.ucm.ucmempire.models.resources;

import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.dto.EntityDTO;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Resource extends Entity implements IResource{
    private ResourceName resourceName;

    public Resource(ResourceName resourceName) {
        this.resourceName = resourceName;
        this.hp = resourceName.getQuantity();
        this.maxhp = Constants.NB_RESSOURCE_VICTORY;
    }

    public Resource(ResourceName resourceName, int quantity) {
        this(resourceName);
        this.hp = quantity;
    }

    public Resource(EntityDTO entityDTO)
    {
        super(entityDTO.getHp());
        this.resourceName = ResourceName.valueOf(entityDTO.getTypeRessource());
    }


    @Override
    public int getRessource(ResourceName resourceName) {
        return resourceName.getQuantity();
    }

    public void setMaxHP(int maxhp){
        this.maxhp = maxhp;
    }


    public ResourceName getResourceName() {
        return resourceName;
    }

    public String getNameOfRessource ()
    {
        return getResourceName().getType();
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceName=" + resourceName +
                ", hp=" + hp +
                "} " + super.toString();
    }
}
