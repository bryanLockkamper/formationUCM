package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.entity.ResourceEntity;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.dto.PlayerDTODetails;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import com.ucm.ucmempire.models.resources.Resource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperPlayer {

    private MapperEntities mapperEntities = new MapperEntities();


    public Player playerEntityToPlayer (PlayerEntity playerEntity)
    {
        Player player = new Player();
        player.setId(playerEntity.getId());
        player.setName(playerEntity.getFirstName());

        if (playerEntity.getEntityGamesList() != null)
        {
            List<Entity> entityList = playerEntity.getEntityGamesList().stream()
                    .filter(e -> !(e instanceof ResourceEntity) )
                    .map(data -> (mapperEntities.entityGameToEntity(data)))
                    .collect(Collectors.toList());


            if (entityList.isEmpty()) {
                player.setEntities(null);
            } else   player.setEntities(entityList);


            Set<Resource> resourceSet = playerEntity.getEntityGamesList().stream()
                    .filter(e -> (e instanceof ResourceEntity) )
                    .map(data -> (Resource)mapperEntities.entityGameToEntity(data))
                    .collect(Collectors.toSet());

            player.setResources(resourceSet);
        } else
        {
            player.setEntities(null);
            player.setResources(null);
        }

        return player;
    }

    public PlayerEntity playerDTODetailsToPlayerEntity (PlayerDTODetails player)
    {
        return new PlayerEntity(player.getId(),player.getLastname(),player.getFirstname(),player.getPseudo(),player.getPassword(),null,null);
    }


}
