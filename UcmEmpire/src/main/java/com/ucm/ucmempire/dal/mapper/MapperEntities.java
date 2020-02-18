package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.*;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;


@Component
public class MapperEntities {

    private Mapper mapper = new DozerBeanMapper();


    public Entity entityGameToEntity (EntityGame entityGame)
    {
        if (entityGame instanceof CharacterEntity)
        {
            switch (entityGame.getType())
            {
                case Constants.TYPE_SOLDIER :
                {
                   return new Soldier(entityGame.getHp(),entityGame.getPlayerEntity().getId(),((CharacterEntity) entityGame).getPa(),((CharacterEntity) entityGame).getDamageSoldier());
                }

                case Constants.TYPE_FARMER :
                {
                    return new Farmer(entityGame.getPlayerEntity().getId(),entityGame.getHp(),((CharacterEntity) entityGame).getPa()); //TODO DAMIEN : resourceHarverst ?
                }
            }
        } else if (entityGame instanceof BuildingEntity)
        {
            switch (entityGame.getType())
            {
                case Constants.TYPE_BARRACKS :
                {
                    return new Barracks(entityGame.getHp(),entityGame.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
                }

                case Constants.TYPE_FORUM :
                {
                    return new Forum(entityGame.getHp(),entityGame.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
                }

                case Constants.TYPE_GRANARY :
                {
                    return new Granary(entityGame.getHp(),entityGame.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
                }

                case Constants.TYPE_HOUSE :
                {
                    return new House(entityGame.getHp(),entityGame.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
                }
            }
        } else if (entityGame instanceof ResourceEntity)
        {
            ResourceName resourceName = ResourceName.valueOf(((ResourceEntity) entityGame).getTypeRessource());
            return new Resource(resourceName,entityGame.getHp());
        }
        return mapper.map(entityGame,Entity.class);
    }

    public EntityGame entityToEntityGame (Entity entity)
    {
        if (entity instanceof Character)
        {
            return mapper.map(entity,CharacterEntity.class);
        } else if (entity instanceof Resource)
        {
            return mapper.map(entity,ResourceEntity.class);
        } else if (entity instanceof Building)
        {
            return mapper.map(entity,BuildingEntity.class);
        } else return mapper.map(entity,EntityGame.class);
    }

}
