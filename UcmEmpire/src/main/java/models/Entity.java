package models;

import models.units.IEntity;

public class Entity implements IEntity {
    protected int hp;
    protected String name;

    public Entity(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(this.hp - hp, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
