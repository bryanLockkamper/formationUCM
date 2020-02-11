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
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity extends EntityGame implements Serializable {



    @Column (name = "pa_character",nullable = false)
    private Integer pa;
    @Column (name = "max_Pa_character",nullable = false)
    private Integer maxPa;


}