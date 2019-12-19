package models.units.unitInterfaces;

import models.boardPackage.Square;
import models.buildings.Building;

public interface IBuilder {
    public int build(Building building, Square squares);
}
