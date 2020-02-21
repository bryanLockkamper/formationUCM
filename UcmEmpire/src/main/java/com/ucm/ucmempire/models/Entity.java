package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.units.IEntity;
import lombok.ToString;

@ToString
public class Entity implements IEntity {
    protected int hp;
    //protected int maxhp;

    public Entity(int hp) {
        this.hp = hp;
        //this.maxhp = hp;
    }

    public Entity() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        //this.hp = Math.min(Math.max(this.hp - hp, 0), this.maxhp);
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


}
