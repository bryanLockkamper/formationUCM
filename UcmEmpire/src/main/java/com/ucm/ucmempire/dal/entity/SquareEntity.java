package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import lombok.*;

import javax.persistence.*;
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

    @Column(name = "isWalkable_square" , nullable = false)
    private boolean isWalkable;
    @Column(name = "isBuildable_square", nullable = false)
    private boolean isBuildable;
    @Column(name = "isSpecial_square", nullable = false)
    private boolean isSpecial;
    @Column(name = "square_type_square" , nullable = false)
    private BiomeType biome;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "square")
    private List<SquareContent> contents;

    @ManyToOne (targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;


}
