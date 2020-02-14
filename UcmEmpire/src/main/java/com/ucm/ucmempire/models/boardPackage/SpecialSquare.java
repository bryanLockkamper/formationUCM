package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.ArrayList;

public class SpecialSquare extends Square {

    private ArrayList<Farmer> farmers;

    public SpecialSquare(ResourceName content) {
        super(new Resource(content), false, true, BiomeType.PLAINS );
    }

    public SpecialSquare(Resource content,BiomeType biomeType,ArrayList<Farmer> farmers) {
        super(content, false, true, biomeType );
        this.farmers = farmers;
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(ArrayList<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void removeFarmer(Farmer farmer) {
        farmers.remove(farmer);
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }
}
