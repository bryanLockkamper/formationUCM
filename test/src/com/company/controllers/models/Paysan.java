package com.company.controllers.models;

import com.company.models.Batiment;
import com.company.models.Case;
import com.company.models.Personnage;

public class Paysan extends Personnage {
    public Paysan(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int recolter(com.company.models.Case cases) {
        return 0;
    }

    public int construire(Batiment batiment, Case cases) {
        return 0;
    }

    @Override
    public String toString() {
        return "P";
    }
}
