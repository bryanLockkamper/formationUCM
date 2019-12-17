package models.unite.UnitInterface;

import models.BoardPackage.Case;
import models.batiments.Batiment;

public interface IConstructeur {
    public int construire(Batiment batiment, Case cases);
}
