package com.ucm.ucmempire.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class PlayerDTORegister {
    private String pseudo;
    private String password;
    private String firstname;
    private String lastname;
}
