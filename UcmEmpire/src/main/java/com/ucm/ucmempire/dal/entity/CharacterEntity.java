package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
public class CharacterEntity extends EntityGame implements Serializable {

    @Column (name = "pa_character")
    private Integer pa;
    @Column (name = "max_Pa_character")
    private Integer maxPa;
    @Column (name = "damage_soldier")
    private Integer damageSoldier;

    public CharacterEntity() {
    }


    public CharacterEntity(Integer hp, String type, PlayerEntity playerEntity, Integer pa, Integer maxPa,Integer damageSoldier) {
        super(hp, type, playerEntity);
        this.pa = pa;
        this.maxPa = maxPa;
        this.damageSoldier = damageSoldier;
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "pa=" + pa +
                ", maxPa=" + maxPa +
                ", damageSoldier=" + damageSoldier +
                "} " + super.toString();
    }
}