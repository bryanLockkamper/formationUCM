package models.batiments;
import models.Entity;
import models.Ressource;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.batiments.BatimentInterfaces.IForum;
import models.unite.Constructeur;
import models.unite.Paysan;
import models.unite.UnitInterface.IConstructeur;
import models.unite.UnitInterface.IPaysan;

import java.util.List;

public class Forum extends BatimentProd implements IForum {

    public Forum(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
    }

}
