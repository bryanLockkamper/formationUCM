package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity extends EntityGame implements Serializable {


    @Column(name = "name_ressource")
     private String type;

}