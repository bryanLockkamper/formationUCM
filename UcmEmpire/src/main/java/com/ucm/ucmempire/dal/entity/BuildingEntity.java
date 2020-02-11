package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Building")
@Getter
@Setter
@ToString
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BuildingEntity extends EntityGame implements Serializable {

    @Column (name = "type_building")
    private String type;


}