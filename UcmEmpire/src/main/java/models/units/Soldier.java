package models.units;

import models.Character;
import models.units.unitInterfaces.ISoldier;

public class Soldier extends Character implements ISoldier {

    public Soldier(int hp, Integer name, int pa) {
    private int damage;

    public Soldier(int hp, String name, int pa , int damage)
    {
        super(hp, name, pa);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
