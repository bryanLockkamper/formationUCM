package com.ucm.ucmempire.models.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTORess {
    private List<ResourceDTO> resources;
}
