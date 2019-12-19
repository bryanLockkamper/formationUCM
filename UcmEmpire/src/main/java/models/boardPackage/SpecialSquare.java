package models.boardPackage;

import models.units.Farmer;

import java.util.ArrayList;

public class SpecialSquare<T> extends Square<T> {


    private ArrayList<Farmer> farmers;
    private int resourceQuantity;

    public SpecialSquare(T content) {  //TODO : add the quantity ressource after the infinity
        super(content, false, true);
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
