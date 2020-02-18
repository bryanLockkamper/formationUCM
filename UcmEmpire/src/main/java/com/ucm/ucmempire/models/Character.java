package com.ucm.ucmempire.models;

import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Character extends Entity {
    private Integer idUser;
    protected int pa;
    protected Position moveLeft;
    private int maxPA;

    public Character(Integer idUser,int hp, int pa) {
        super(hp);
        this.idUser = idUser;
        this.pa = pa;
        maxPA = pa;
    }

    public void move(PositionDTO move) {
        this.pa -= move.getPa();
        moveLeft = move.getPosition();
    }

    public void setMaxPA() {
        pa = maxPA;
    }
}
