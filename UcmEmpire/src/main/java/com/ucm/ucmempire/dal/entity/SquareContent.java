package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@EqualsAndHashCode

@Table(name = "square_content")
@IdClass(SquareContent.class)
public class SquareContent implements Serializable {
    @Id
    @JoinColumn(name = "square",referencedColumnName = "id_square")
    @ManyToOne(targetEntity = SquareEntity.class)
    private SquareEntity square;

    @Id
    @ManyToOne(targetEntity = EntityGame.class)
    @JoinColumn(name = "entity_game",referencedColumnName = "id_entity_game")
    private EntityGame entityGame;

    @Column(name = "quantity_square_resource")
    private Integer nbResources;

    public SquareContent() {
    }

    public SquareContent(SquareEntity squareEntity,EntityGame entityGame,Integer nbResources)
    {
        this.square = squareEntity;
        this.entityGame = entityGame;
        this.nbResources = nbResources;
    }

    public SquareEntity getSquare() {
        return square;
    }

    public void setSquare(SquareEntity square) {
        this.square = square;
    }

    public EntityGame getEntityGame() {
        return entityGame;
    }

    public void setEntityGame(EntityGame entityGame) {
        this.entityGame = entityGame;
    }

    public Integer getNbResources() {
        return nbResources;
    }

    public void setNbResources(Integer nbResources) {
        this.nbResources = nbResources;
    }

    @Override
    public String toString() {
        return "SquareContent{" +
                "square=" + square +
                ", entityGame=" + entityGame +
                ", nbResources=" + nbResources +
                '}';
    }
}
