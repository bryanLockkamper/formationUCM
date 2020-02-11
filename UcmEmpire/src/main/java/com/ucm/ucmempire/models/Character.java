package com.ucm.ucmempire.models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Character extends Entity {
    protected int pa;
    protected int moveLeft;
    private int maxPA;

    public Character(int hp, Integer id, int pa) {
        super(hp, id);
        this.pa = pa;
        maxPA = pa;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int move(int move) {
        int tmp = move - pa;
        pa = Math.max(pa - move, 0);
        return tmp;
    }


    public void autoMove() {

    }

    public void setMaxPA() {
        pa = maxPA;
    }
}
