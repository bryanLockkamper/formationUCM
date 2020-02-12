package com.ucm.ucmempire.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class PlayerDTOLogin {
    private String pseudo;
    private String pwd;
}
