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
            if (entity instanceof Soldier) //TODO DAMIEN : how to insert the player ?
            {
                return new CharacterEntity(entity.getHp(),Constants.TYPE_SOLDIER,new PlayerEntity(),((Soldier) entity).getPa(),((Soldier) entity).getPa(),((Soldier) entity).getDamage() );
            } else if (entity instanceof Farmer)
            {
                return new CharacterEntity(entity.getHp(),Constants.TYPE_FARMER,new PlayerEntity(),((Farmer) entity).getPa(),((Farmer) entity).getPa(),null );
            } else return mapper.map(entity,CharacterEntity.class);

        } else if (entity instanceof Resource)
        {
            return new ResourceEntity(entity.getHp(),Constants.TYPE_RESSOURCE,new PlayerEntity(),((Resource) entity).getResourceName().getType());

        } else if (entity instanceof Building)
        {
            if (entity instanceof House)
            {
                return new BuildingEntity(entity.getHp(),Constants.TYPE_HOUSE,new PlayerEntity());
            } else if (entity instanceof Forum)
            {
                return new BuildingEntity(entity.getHp(),Constants.TYPE_FORUM,new PlayerEntity());
            } else if (entity instanceof Barracks)
            {
                return new BuildingEntity(entity.getHp(),Constants.TYPE_BARRACKS,new PlayerEntity());
            } else if (entity instanceof Granary)
            {
                return new BuildingEntity(entity.getHp(),Constants.TYPE_GRANARY,new PlayerEntity());
            } else return mapper.map(entity,BuildingEntity.class); //TODO DAMIEN : Update the mapper default return by an Exception

        } else return mapper.map(entity,EntityGame.class);
    }

}
