package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode (callSuper = true)
public class SpecialSquareDTO extends SquareDTO {

    /*private ArrayList<FarmerDTO> farmers;
    private Integer ressourceQuantity;

    public SpecialSquareDTO(ResourceName content,String biome) {
        super(false, true, biome ,new Resource(content) );
    }*/
}
