package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode (callSuper = true)
public class BuildingEntity extends EntityGame implements Serializable {

    /*@Column (name = "type_building")
    private String type;*/

    //TODO DAMIEN : Need to add the relation with Ressource and character


    public BuildingEntity() {
    }

    public BuildingEntity(Integer hp, String type, PlayerEntity playerEntity) {
        super(hp, type, playerEntity);
    }
}