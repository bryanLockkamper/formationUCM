package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode (callSuper = true)
public class CharacterEntity extends EntityGame implements Serializable {

    @Column (name = "pa_character")
    private Integer pa;
    @Column (name = "max_Pa_character")
    private Integer maxPa;

    public CharacterEntity() {
    }

    public CharacterEntity(Integer id, int hp, String type, Integer pa, Integer maxPa) {
        super(id, hp, type);
        this.pa = pa;
        this.maxPa = maxPa;
    }
}