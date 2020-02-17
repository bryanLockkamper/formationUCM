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
    private Set<EntityGame> entityGamesList;

    @ManyToOne (targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;





}