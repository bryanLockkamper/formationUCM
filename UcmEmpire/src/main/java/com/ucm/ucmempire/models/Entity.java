package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.units.IEntity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Entity implements IEntity {
    protected int hp;
    protected int maxhp;

    public Entity(int hp) {
        this.hp = hp;
        this.maxhp = hp;
    }

    public Entity() { }

    public Entity (EntityDTO entityDTO)
    {
        this.hp = entityDTO.getHp();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0,Math.min(hp,maxhp));

    }

    /**
     *
     * @param damage damage done on this unit
     * @return true if dead
     */
    public boolean takeDamage(int damage){
        setHp(getHp()-damage);
        return getHp() <= 0;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "hp=" + hp +
                '}';
    }
}
