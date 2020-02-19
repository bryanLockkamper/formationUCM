package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import lombok.*;

import javax.persistence.*;
import javax.validation.Constraint;
import java.io.Serializable;
import java.util.List;

@javax.persistence.Entity
@Table(name = "square")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SquareEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_square" , nullable = false)
    private Integer id;

    @Column(name = "is_Walkable_square" , nullable = false)
    private boolean isWalkable;
    @Column(name = "is_Buildable_square", nullable = false)
    private boolean isBuildable;
    @Column(name = "is_Special_square", nullable = false)
    private boolean isSpecial;
    @Column(name = "biome_type_square" , nullable = false)
    private String biome;
    @Column (name = "position_square",nullable = false)
    private String positionSquare;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "square")
    private List<SquareContent> contents;

    /*@JoinColumn(name = "board",referencedColumnName = "id_board")
    @OneToOne (targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;*/


}
