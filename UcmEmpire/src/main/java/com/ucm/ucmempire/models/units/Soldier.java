package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.units.unitInterfaces.ISoldier;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Soldier extends Character implements ISoldier {

    private int damage;

    public Soldier(int idUser) {
        super(idUser, Constants.NB_POINTDEVIE, Constants.NB_POINTACTION);
        this.damage =Constants.NB_DOMMAGE;
    }

    public Soldier(int user_id, int hp, int pa)
    {
        super(hp, user_id, pa);
    }

    public Soldier(int user_id, int hp,  int pa , int damage)
    {
        this(user_id, hp,  pa);
        this.damage = damage;
    }

    public Soldier (EntityDTO entityDTO)
    {
        super(entityDTO.getIdPlayer(),entityDTO.getHp(),entityDTO.getPa());
        this.damage = entityDTO.getDamage();
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
