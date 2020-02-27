package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.units.unitInterfaces.ISoldier;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Soldier extends Character implements ISoldier {

    private int damage;

    public Soldier(int hp, Integer idUser, int pa)
    {
        super(hp, idUser, pa);
    }

    public Soldier(int hp, Integer idUser, int pa , int damage)
    {
        this(hp, idUser, pa);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "damage=" + damage +
                ", pa=" + pa +
                ", moveLeft=" + moveLeft +
                ", hp=" + hp +
                "} " + super.toString();
    }
}
