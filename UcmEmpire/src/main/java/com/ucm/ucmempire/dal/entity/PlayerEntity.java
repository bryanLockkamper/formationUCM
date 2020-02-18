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
@NoArgsConstructor
@AllArgsConstructor
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


    @OneToMany(targetEntity = EntityGame.class,mappedBy = "player",fetch = FetchType.LAZY)
    private List<EntityGame> entityGamesList;

    @ManyToOne (targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", entityGamesList=" + entityGamesList +
                ", boardEntity=" + boardEntity +
                '}';
    }
}