package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources( SpecialSquare squareResource, Player player) {

        List<Farmer> farmers = player.getEntities().stream().filter(entity -> entity instanceof Farmer).map(entity -> (Farmer)entity).collect(Collectors.toList());
        int harvest =0;

        if (squareResource != null) {
            for (Farmer farmer : farmers) {
                if (squareResource.getResourceQuantity() >= 0) {
                    int actualResource = player.getResources(((Resource) squareResource.getContent()).getResourceName());
                    harvest += farmer.getPa();

                    if (squareResource.getResourceQuantity() - harvest >= 0)
                        squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                    else {
                        harvest = squareResource.getResourceQuantity();
                        squareResource.setResourceQuantity(0);
                    }

                    if (player.getMaxResources() + harvest <= player.getMaxResources())
                        player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), harvest + actualResource));

                    else {
                        player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), player.getMaxResources()));
                    }

                    farmer.setPa(0);

                    return harvest;
                }
            }
        }
        return harvest;
    }
}
