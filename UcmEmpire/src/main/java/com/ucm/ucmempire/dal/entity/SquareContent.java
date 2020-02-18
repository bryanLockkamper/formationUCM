package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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


}
