package com.ucm.ucmempire.models;

import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;

import com.ucm.ucmempire.models.dto.EntityDTO;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Character extends Entity {
    private Integer idUser;
    protected int pa;
    protected Position moveLeft;
    private int maxPA;

    public Character() {
    }

    public Character(Integer idUser, int hp, int pa) {
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



    public void move(PositionDTO move) {
        this.pa -= move.getPa();
        moveLeft = move.getPosition();
    }

    public int getMaxPA() {
        return maxPA;
    }

    public void setMaxPA() {
        pa = maxPA; }

    public Position getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(Position moveLeft) {
        this.moveLeft = moveLeft;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idUser=" + idUser +
                ", pa=" + pa +
                ", moveLeft=" + moveLeft +
                ", maxPA=" + maxPA +
                ", hp=" + hp +
                ", maxhp=" + maxhp +
                "} " + super.toString();
    }
}
