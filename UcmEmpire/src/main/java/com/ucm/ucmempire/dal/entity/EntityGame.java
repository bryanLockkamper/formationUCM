package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.models.units.IEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "entity_game")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EntityGame implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "hp_entity" , nullable = false)
    protected int hp;

    public EntityGame(int hp, Integer id) {
        this.hp = hp;
        this.id = id;
    }



}
