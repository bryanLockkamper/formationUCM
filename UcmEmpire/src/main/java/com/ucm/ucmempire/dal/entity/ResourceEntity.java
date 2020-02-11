package com.ucm.ucmempire.dal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Resource")
public class ResourceEntity extends EntityGame implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resoucre")
     private Integer id;
    @Column(name = "name_resource")
     private String type;

    public ResourceEntity() {
    }
}
