package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.ArrayList;

public class SpecialSquare extends Square {

    private ArrayList<Farmer> farmers;
    private int resourceQuantity;

    public SpecialSquare(ResourceName content) {  //TODO : add the quantity ressource after the infinity
        super(new Resource(content), false, true, BiomeType.PLAINS ); //TODO : change the default biome by a neutral biome for specialSquare
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(ArrayList<Farmer> farmers) {
        this.farmers = farmers;
    }

    public int getResourceQuantity() {
        return resourceQuantity;
    }

    public void setResourceQuantity(int resourceQuantity) {
        this.resourceQuantity = resourceQuantity;
    }

}
