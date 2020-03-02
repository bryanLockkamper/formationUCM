package com.ucm.ucmempire.models.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class PlayerDTODetails {
    private String pseudo;
    private String password;
    private String firstname;
    private String lastname;
    private Integer id;
}
