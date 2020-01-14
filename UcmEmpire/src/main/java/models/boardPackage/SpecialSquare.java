package models.boardPackage;

import models.Entity;
import models.resources.ResourceName;
import models.units.Farmer;

import java.util.ArrayList;

public class SpecialSquare extends Square {


    private ArrayList<Farmer> farmers;
    private int resourceQuantity;

    public SpecialSquare(ResourceName content) {  //TODO : add the quantity ressource after the infinity
        super(new Entity(Integer.MAX_VALUE, content.getType()), false, true, null);
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
