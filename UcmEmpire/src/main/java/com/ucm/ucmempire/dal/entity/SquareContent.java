package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "SquareContent")
public class SquareContent implements Serializable {
    @Id
    @ManyToOne(targetEntity = SquareEntity.class)
    private SquareEntity square;
    @Id
    @ManyToOne(targetEntity = EntityGame.class)
    private EntityGame entityGame;
    @Column(name = "quantity_square_resource")
    private Integer nbResources;

    public SquareContent() {
    }
}
