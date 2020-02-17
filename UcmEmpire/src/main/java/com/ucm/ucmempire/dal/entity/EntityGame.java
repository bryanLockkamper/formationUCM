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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EntityGame implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hp_entity" , nullable = false)
    private Integer hp;
    @Column(name = "type_entity")
    private String type;

    @JoinColumn (name = "player",referencedColumnName = "id_player")
    @ManyToOne
    private PlayerEntity playerEntity;

    public EntityGame() {
    }

    public EntityGame(Integer hp, String type, PlayerEntity playerEntity) {
        this.hp = hp;
        this.type = type;
        this.playerEntity = playerEntity;
    }
}
