package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTODetails {
    private String pseudo;
    private String password;
    private String firstname;
    private String lastname;
    private Integer id;
    private String mail;


}
