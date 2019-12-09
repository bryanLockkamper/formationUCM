package com.company.models;

public class Soldat extends Personnage {
    public Soldat(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int attaquer(Entity entity){
        return 0;
    }
}
