package com.ucm.ucmempire.dal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Building")
@Data
public class BuildingEntity extends EntityGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building")
    private Long id;
    @Column (name = "hp_building",nullable = false)
    private Integer hp;

    @ManyToOne(targetEntity = PlayerEntity.class)
    private PlayerEntity player;

    public BuildingEntity() {
    }
}