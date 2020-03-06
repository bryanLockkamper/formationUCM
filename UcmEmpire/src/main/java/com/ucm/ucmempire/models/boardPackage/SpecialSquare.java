package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.dto.SquareDTO;
import com.ucm.ucmempire.models.dto.TypeEntity;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
public class SpecialSquare extends Square {

    private List<Farmer> farmers = new ArrayList<>();

    private int resourceQuantity;

    public SpecialSquare(ResourceName content) {
        super(new Resource(content), false, true, BiomeType.PLAINS );
    }

    public SpecialSquare(Resource content,BiomeType biomeType,List<Farmer> farmers) {
        super(content, false, true, biomeType );
        this.farmers = farmers;
    }

    public SpecialSquare(SquareDTO squareDTO)
    {
        super(squareDTO.getEntityDTOList().stream().filter(data -> data.getTypeEntity().equals(TypeEntity.RESSOURCE)).findFirst().map(Resource::new).orElse(null),BiomeType.valueOf(squareDTO.getBiomeType()));
        this.farmers = squareDTO.getEntityDTOList().stream().filter(data -> data.getTypeEntity().equals(TypeEntity.FARMER)).map(Farmer::new).collect(Collectors.toList());
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(ArrayList<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void removeFarmer(Farmer farmer) {
        farmers.remove(farmer);
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    @Override
    public String toString() {
        return "SpecialSquare{" +
                "farmers=" + farmers +
                "} " + super.toString();
    }
}
