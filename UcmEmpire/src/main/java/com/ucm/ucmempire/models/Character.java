package com.ucm.ucmempire.models;

import com.ucm.ucmempire.models.dto.EntityDTO;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Character extends Entity { //TODO EVRYONE : Why character is not abstract ?
    private Integer idUser;
    protected int pa;
    protected int moveLeft; //TODO (ALEX & Bryan) : Need to replace bay a list af move
    private int maxPA;

    public Character(Integer idUser,int hp, int pa) {
        super(hp);
        this.idUser = idUser;
        this.pa = pa;
        maxPA = pa;
    }

    public Character(EntityDTO entityDTO)
    {
        super(entityDTO.getHp());
        this.idUser = entityDTO.getIdPlayer();
        this.pa = entityDTO.getPa();
        this.maxPA = entityDTO.getMaxPa();
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


    public int getMaxPA() {
        return maxPA;
    }

    public void setMaxPA() {
        pa = maxPA;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idUser=" + idUser +
                ", pa=" + pa +
                ", moveLeft=" + moveLeft +
                ", maxPA=" + maxPA +
                ", hp=" + hp +
                "} " + super.toString();
    }
}
