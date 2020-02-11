package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "character")
@Data
public class CharacterEntity extends EntityGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Long id;
    @Column (name = "hp_character",nullable = false)
    private Integer hp;
    @Column (name = "pa_character",nullable = false)
    private Integer pa;
    @Column (name = "maxPa_character",nullable = false)
    private Integer maxPa;

    @ManyToOne(targetEntity = PlayerEntity.class)
    private PlayerEntity playerEntity;

    public CharacterEntity() {
    }
}