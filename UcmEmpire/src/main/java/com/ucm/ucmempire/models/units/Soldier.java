package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.units.unitInterfaces.ISoldier;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Soldier extends Character implements ISoldier {

    private int damage;

    public Soldier(int hp, Integer id, int pa)
    {
        super(id, hp, pa);
    }

    public Soldier(int hp, Integer id, int pa , int damage)
    {
        this(hp, id, pa);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
