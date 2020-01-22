package services;

import models.Entity;
import models.Player;
import models.boardPackage.SpecialSquare;
import models.resources.Resource;
import models.units.Farmer;
import models.units.unitInterfaces.IFarmer;

public class HarvestService {

    public int autoHarvestResources(Farmer farmer, SpecialSquare squareResource, Player player) {

        if (farmer != null && squareResource != null) {
            for (Entity entity : player.getEntities()) {
                if (entity instanceof IFarmer && squareResource.getResourceQuantity() >= 0) {
                    int actualResource = player.getResources(((Resource) squareResource.getContent()).getResourceName());
                    int harvest = farmer.getPa();

                    if (squareResource.getResourceQuantity() - harvest >= 0)
                        squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                    else {
                        harvest = squareResource.getResourceQuantity();
                        squareResource.setResourceQuantity(0);
                    }

                    if (player.getMaxResources() + harvest <= player.getMaxResources())
                        player.getResources().add(new Resource(((Farmer) entity).getResourceHarvesting(), harvest + actualResource));

                    else {
                        player.getResources().add(new Resource(((Farmer) entity).getResourceHarvesting(), player.getMaxResources()));
                    }

                    farmer.setPa(0);

                    return harvest;
                }
            }
        }
        return 0;
    }
}
