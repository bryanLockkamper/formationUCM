package com.company.models;

public class Paysan extends Personnage {
    public Paysan(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int recolter(Case cases) {
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
