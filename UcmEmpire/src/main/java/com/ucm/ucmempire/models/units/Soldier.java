package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.units.unitInterfaces.ISoldier;

public class Soldier extends Character implements ISoldier {

    private int damage;

    public Soldier(int hp, Integer name, int pa)
    {
        super(hp, name, pa);
    }

    public Soldier(int hp, Integer name, int pa , int damage)
    {
        this(hp, name, pa);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
