package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources(SpecialSquare squareResource, Player player) {

        int harvest = 0;

        if (player.getEntities() != null) {
            List<Farmer> playerFarmerList = player.getEntities().stream()
                    .filter(entity -> entity instanceof Farmer)
                    .map(entity -> (Farmer) entity)
                    .collect(Collectors.toList());
            if (squareResource.getFarmers() != null) {
                List<Farmer> farmers = squareResource.getFarmers().stream()
                        .filter(farmer -> {return playerFarmerList.contains(farmer) && farmer.getIdUser() == player.getId();})
                        .collect(Collectors.toList());

                System.out.println(farmers.toString());
                for (Farmer farmer : farmers) {
                    if (squareResource.getResourceQuantity() >= 0) {
                        Resource actualResource = player.getResources().stream()
                                .filter(resource -> resource.getResourceName().getType().equals(((Resource) squareResource.getContent()).getNameOfRessource()))
                                .findFirst().orElseThrow(NullPointerException::new);
                        harvest += farmer.getPa();
                        System.out.println(harvest);
                        System.out.println(player.getEntities().toString());

                        if (squareResource.getResourceQuantity() - harvest >= 0)
                            squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                        else {
                            harvest = squareResource.getResourceQuantity();
                            squareResource.setResourceQuantity(0);
                        }

                        player.getResources().remove(actualResource);

                        if (player.getMaxResources() + harvest <= player.getMaxResources()) {
                            actualResource.setHp(actualResource.getHp() + harvest);
                        } else {
                            actualResource.setHp(player.getMaxResources());
                        }

                        player.getResources().add(actualResource);
                        farmer.setPa(0);
                    }
                }
            }
        }

        return harvest;
    }
}
