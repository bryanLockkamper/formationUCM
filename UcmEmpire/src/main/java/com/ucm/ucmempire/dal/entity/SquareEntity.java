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
@EqualsAndHashCode
public class SquareEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_square")
    private Integer id;

    @Column(name = "is_Walkable_square" , nullable = false)
    private boolean isWalkable;
    @Column(name = "is_Buildable_square", nullable = false)
    private boolean isBuildable;
    @Column(name = "is_Special_square", nullable = false)
    private boolean isSpecial;
    @Column(name = "biome_type_square" , nullable = true) //TODO DAMIEN : need to check if it's come from specialSquare with no biome or not
    private String biome;
    @Column (name = "position_square",nullable = false)
    private String positionSquare;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "square")
    private List<SquareContent> contents;

    public SquareEntity() {
    }

    public SquareEntity (Integer id, boolean isWalkable,boolean isBuildable,boolean isSpecial,String biome,String positionSquare,List<SquareContent> contents)
    {
        this.id = id;
        this.isSpecial = isSpecial;
        this.isBuildable = isBuildable;
        this.isWalkable = isWalkable;
        this.positionSquare = positionSquare;
        this.contents = contents;
        this.biome = biome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWalkable() {
        return isWalkable;
    }

    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildable(boolean buildable) {
        isBuildable = buildable;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getPositionSquare() {
        return positionSquare;
    }

    public void setPositionSquare(String positionSquare) {
        this.positionSquare = positionSquare;
    }

    public List<SquareContent> getContents() {
        return contents;
    }

    public void setContents(List<SquareContent> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "SquareEntity{" +
                "id=" + id +
                ", isWalkable=" + isWalkable +
                ", isBuildable=" + isBuildable +
                ", isSpecial=" + isSpecial +
                ", biome='" + biome + '\'' +
                ", positionSquare='" + positionSquare + '\'' +
                ", contents=" + contents +
                '}';
    }
}
