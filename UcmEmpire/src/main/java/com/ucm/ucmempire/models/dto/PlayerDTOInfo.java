package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import lombok.Data;

@Data
public class PlayerDTOInfo {

    private String pseudo;
    private String firstname;
    private String lastname;
    private Integer id;
    private String mail;

    public PlayerDTOInfo() {
    }

    public PlayerDTOInfo(PlayerEntity playerEntity) {
        this.pseudo = playerEntity.getLogin();
        this.firstname = playerEntity.getFirstName();
        this.lastname = playerEntity.getLastName();
        this.mail = playerEntity.getMail();
        this.id = playerEntity.getId();
    }
}
