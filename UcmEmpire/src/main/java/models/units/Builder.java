package models.units;

import models.Character;
import models.boardPackage.Square;
import models.buildings.Building;
import models.units.unitInterfaces.IBuilder;

public class Builder extends Character implements IBuilder {

    public Builder(int pv, Integer name, int pa) {
        super(pv, name, pa);
    }

    public int build(Building building, Square squares) {
        return 0;
    }

    @Override
    public String toString() {
        return "B";
    }
}
