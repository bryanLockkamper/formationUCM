package com.ucm.ucmempire.models;

import lombok.EqualsAndHashCode;


public class Character extends Entity {
    private Integer idUser;
    protected int pa;
    protected int moveLeft; //TODO : Need to replace bay a list af move (ALEX & Bryan)
    private int maxPA;

    public Character(Integer idUser,int hp, int pa) {
        super(hp);
        this.idUser = idUser;
        this.pa = pa;
        maxPA = pa;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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


    public void autoMove() { //TODO : autoMove is empty BRYAN

    }

    public void setMaxPA() {
        pa = maxPA;
    }
}
