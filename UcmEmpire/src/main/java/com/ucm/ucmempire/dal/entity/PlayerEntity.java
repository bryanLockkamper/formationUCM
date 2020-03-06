package com.ucm.ucmempire.dal.entity;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import com.ucm.ucmempire.dal.entity.CharacterEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "player")
@Getter
@Setter
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
    @Column (name = "mail_player",nullable = false)
    private String mail;


    @OneToMany(targetEntity = EntityGame.class,fetch = FetchType.LAZY)
    private List<EntityGame> entityGamesList;

    @ManyToOne (targetEntity = BoardEntity.class)
   // @JoinColumn(name = "board_entity_id_board",referencedColumnName = "id_board")
    private BoardEntity boardEntity;

    public PlayerEntity() {
    }

    public PlayerEntity(String login,String password)
    {
        this.login = login;
        this.password = password;
    }

    public PlayerEntity(String lastname, String firstname, String pseudo, String pwd) {
        this(pseudo,pwd);
        this.lastName = lastname;
        this.firstName = firstname;
    }

    public PlayerEntity(String lastname, String firstname, String pseudo, String pwd,Integer id, BoardEntity boardEntity, List<EntityGame> entityGamesList) {
        this(lastname,firstname,pseudo,pwd);
        this.id = id;
        this.boardEntity = boardEntity;
        this.entityGamesList = entityGamesList;
    }

    public PlayerEntity(Integer id, String lastName, String firstName, String login, String password,String mail, List<EntityGame> entityGamesList, BoardEntity boardEntity) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.entityGamesList = entityGamesList;
        this.boardEntity = boardEntity;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", entityGamesList=" + entityGamesList +
                ", boardEntity=" + boardEntity +
                '}';
    }
}