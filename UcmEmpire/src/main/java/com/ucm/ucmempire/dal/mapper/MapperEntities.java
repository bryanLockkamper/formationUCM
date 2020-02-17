package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.*;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
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
                    return mapper.map(entityGame,Barracks.class);
                }

                case Constants.TYPE_FARMER :
                {
                    return mapper.map(entityGame, Farmer.class);
                }
            }
        } else if (entityGame instanceof BuildingEntity)
        {
            switch (entityGame.getType())
            {
                case Constants.TYPE_BARRACKS :
                {
                    return mapper.map(entityGame, Barracks.class);
                }

                case Constants.TYPE_FORUM :
                {
                    return mapper.map(entityGame, Forum.class);
                }

                case Constants.TYPE_GRANARY :
                {
                    return mapper.map(entityGame, Granary.class);
                }

                case Constants.TYPE_HOUSE :
                {
                    return mapper.map(entityGame, House.class);
                }
            }
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
