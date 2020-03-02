package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
public class ResourceEntity extends EntityGame implements Serializable {


    @Column(name = "ressource_name")
     private String typeRessource;

    public ResourceEntity() {
    }

    public ResourceEntity(Integer hp, String type, PlayerEntity playerEntity,String typeRessource) {
        super(hp, type, playerEntity);
        this.typeRessource = typeRessource;
    }

    @Override
    public String toString() {
        return "ResourceEntity{" +
                "typeRessource='" + typeRessource + '\'' +
                "} " + super.toString();
    }
}
