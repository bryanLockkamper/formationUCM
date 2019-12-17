package models.BoardPackage;

import models.unite.Paysan;

import java.util.ArrayList;

public class CaseSpecial<T> extends Case<T> {


    private ArrayList<Paysan> paysans;
    private int quantityRessource;

    public CaseSpecial(T content) {  //TODO : add the quantity ressource after the infinity
        super(content, false, true);
    }

    public ArrayList<Paysan> getPaysans() {
        return paysans;
    }

    public void setPaysans(ArrayList<Paysan> paysans) {
        this.paysans = paysans;
    }

    public int getQuantityRessource() {
        return quantityRessource;
    }

    public void setQuantityRessource(int quantityRessource) {
        this.quantityRessource = quantityRessource;
    }
}
