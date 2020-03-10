package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.models.Player;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTORegister {
    private String pseudo;
    private String password;
    private String firstname;
    private String lastname;
    private String email;


}
