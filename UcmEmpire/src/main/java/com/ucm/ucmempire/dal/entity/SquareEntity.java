package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@javax.persistence.Entity
@Table(name = "square")
@Data
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

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<SquareContent> contents;

//    public SquareEntity(List<SquareContent> contents) {
//        this.contents = contents;
//    }
//
//    public SquareEntity(List<SquareContent> contents, boolean isBuildable, boolean isWalkable, BiomeType biome) {
//        this(contents);
//        this.isBuildable = isBuildable;
//        this.isWalkable = isWalkable;
//        this.biome = biome;
//    }

    public SquareEntity() {
    }

    @Override
    public String toString() {
        return contents.toString() ;
    }
}
