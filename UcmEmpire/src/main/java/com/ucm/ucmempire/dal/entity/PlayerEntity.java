package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import com.ucm.ucmempire.dal.entity.CharacterEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "player")
@Data
public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Long id;
    @Column (name = "lastName_player",nullable = false)
    private String lastName;
    @Column (name = "firstName_player",nullable = false)
    private String firstName;
    @Column (name = "login_player",nullable = false,unique = true)
    private String login;
    @Column (name = "password_player",nullable = false)
    private String password;

//    @OneToMany(targetEntity = BuildingEntity.class)
//    private Set<BuildingEntity> buildingEntitySet;
//
//    @OneToMany (targetEntity = CharacterEntity.class)
//    private Set<CharacterEntity> characterEntitySet;

    @OneToMany(targetEntity = EntityGame.class)
    private Set<EntityGame> entityGamesList;

    public PlayerEntity() {
    }
//TODO : link with RESSOURCE table and BOARD table


}