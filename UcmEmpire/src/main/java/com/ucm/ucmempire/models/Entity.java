package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.units.IEntity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Entity implements IEntity {
    protected int hp;

    public Entity(int hp) {
        this.hp = hp;
    }

    public Entity() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(this.hp - hp, 0);
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
