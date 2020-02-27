package com.ucm.ucmempire.models.units.unitInterfaces;

import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.Building;

public interface IBuilder {
    public int build(Building building, Square squares);
}
