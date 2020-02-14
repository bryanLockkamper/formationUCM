package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import com.ucm.ucmempire.dal.entity.CharacterEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "player")
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Integer id;
    @Column (name = "last_Name_player",nullable = false)
    private String lastName;
    @Column (name = "first_Name_player",nullable = false)
    private String firstName;
    @Column (name = "login_player",nullable = false,unique = true)
    private String login;
    @Column (name = "password_player",nullable = false)
    private String password;


    @OneToMany(targetEntity = EntityGame.class)
    private Set<EntityGame> entityGamesList;

    @ManyToOne (targetEntity = BoardEntity.class, optional = true)
   // @JoinColumn(name = "board_entity_id_board",referencedColumnName = "id_board")
    private BoardEntity boardEntity;

    public PlayerEntity() {
    }

    public PlayerEntity(String lastname, String firstname, String pseudo, String pwd) {
        this.lastName = lastname;
        this.firstName = firstname;
        this.password = pwd;
        this.login = pseudo;
    }

    public PlayerEntity(String lastname, String firstname, String pseudo, String pwd,Integer id, BoardEntity boardEntity, Set<EntityGame> entityGamesList) {
        this(lastname,firstname,pseudo,pwd);
        this.id = id;
        this.boardEntity = boardEntity;
        this.entityGamesList = entityGamesList;
    }
}