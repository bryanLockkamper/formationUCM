package com.ucm.ucmempire.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHasLostDTO {
    private Integer player_id;
    private String player_login;
    private Boolean player_hasLost;
}
