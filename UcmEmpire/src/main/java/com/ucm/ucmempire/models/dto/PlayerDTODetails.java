package com.ucm.ucmempire.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTODetails {
    private String pseudo;
    private String password;
    private String firstname;
    private String lastname;
    private Integer id;
    private String mail;


}
