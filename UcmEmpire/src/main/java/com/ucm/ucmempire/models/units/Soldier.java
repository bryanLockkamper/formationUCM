package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.units.unitInterfaces.ISoldier;

public class Soldier extends Character implements ISoldier {

    private int damage;

    public Soldier(int user_id, int hp, int pa)
    {
        super(hp, user_id, pa);
    }

    public Soldier(int user_id, int hp,  int pa , int damage)
    {
        this(user_id, hp,  pa);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
