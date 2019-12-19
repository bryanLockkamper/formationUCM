package models.units;

import models.Character;
import models.units.unitInterfaces.ISoldier;

public class Soldier extends Character implements ISoldier {

    public Soldier(int hp, String name, int pa) {
        super(hp, name, pa);
    }

    public int attack(){
        return getPa();
    }
}
