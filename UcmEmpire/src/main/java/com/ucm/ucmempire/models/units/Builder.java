package com.ucm.ucmempire.models.units;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.Building;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.units.unitInterfaces.IBuilder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
public class Builder extends Character implements IBuilder {

    public Builder(int pv, Integer idUser, int pa) {
        super(pv, idUser, pa);
    }

    public int build(Building building, Square squares) {
        return 0;
    }

    public Builder (EntityDTO entityDTO)
    {
        super(entityDTO.getIdPlayer(),entityDTO.getHp(),entityDTO.getPa());
    }

    @Override
    public String toString() {
        return "Builder{" +
                "pa=" + pa +
                ", moveLeft=" + moveLeft +
                ", hp=" + hp +
                "} " + super.toString();
    }
}
