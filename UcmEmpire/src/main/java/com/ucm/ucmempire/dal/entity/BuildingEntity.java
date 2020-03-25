package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return "BuildingEntity{} " + super.toString();
    }
}