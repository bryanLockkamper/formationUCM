package models.ressources;

import models.ressources.RessourceName;

public class Ressource {
    private RessourceName name;
    private int number;

    public Ressource(RessourceName name, int number) {
        this.name = name;
        this.number = number;
    }

    public RessourceName getName() {
        return name;
    }

    public void setName(RessourceName name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
