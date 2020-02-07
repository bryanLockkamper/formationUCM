package models;

import models.units.IEntity;

public class Entity implements IEntity {
    protected int hp;
    protected Integer id;

    public Entity(int hp, Integer id) {
        this.hp = hp;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void suicide() {
        this.hp = 0;
    }

}
