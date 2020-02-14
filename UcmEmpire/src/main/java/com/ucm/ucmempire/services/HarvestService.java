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
        //TODO ALEX : check if the farmer is in this specialSquare and not all the farmer
        int harvest =0;

        if (squareResource != null) {
            for (Farmer farmer : farmers) {
                if (squareResource.getContent().getHp() >= 0) {
                    Resource actualResource = player.getResources().stream()
                            .filter(resource -> resource.getResourceName().getType().equals(squareResource.getContent().getClass().getSimpleName()))
                            .findFirst().orElseThrow(NullPointerException::new);
                    harvest += farmer.getPa();

                    if (squareResource.getContent().getHp() - harvest >= 0)
                        squareResource.getContent().setHp(squareResource.getContent().getHp() - harvest);

                    else {
                        harvest = squareResource.getContent().getHp();
                        squareResource.getContent().setHp(0);
                    }

                    player.getResources().remove(actualResource);

                    if (player.getMaxResources() + harvest <= player.getMaxResources()) {
                        actualResource.setHp(actualResource.getHp()+ harvest);
                    }

                    else {
                        actualResource.setHp(player.getMaxResources());
                    }

                    player.getResources().add(actualResource);
                    farmer.setPa(0);

                    return harvest;
                }
            }
        }
        return harvest;
    }
}
