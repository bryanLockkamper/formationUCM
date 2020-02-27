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
import org.dozer.MappingException;
import org.springframework.stereotype.Component;


@Component
public class MapperEntities {



    public Entity entityGameToEntity (EntityGame entityGame)
    {
        if (entityGame instanceof CharacterEntity)
        {
            return characterEntityToCharacter((CharacterEntity) entityGame);
        } else if (entityGame instanceof BuildingEntity)
        {
            return buildingEntityToBuilding((BuildingEntity) entityGame);
        } else if (entityGame instanceof ResourceEntity)
        {
            ResourceName resourceName = ResourceName.valueOf(((ResourceEntity) entityGame).getTypeRessource());
            return new Resource(resourceName,entityGame.getHp());
        }
        return null;
    }

    public Character characterEntityToCharacter (CharacterEntity characterEntity)
    {
        switch (characterEntity.getType())
        {
            case Constants.TYPE_SOLDIER :
            {
                return new Soldier(characterEntity.getHp(),characterEntity.getPlayerEntity().getId(),( characterEntity).getPa(),(characterEntity).getDamageSoldier());
            }

            case Constants.TYPE_FARMER :
            {
                return new Farmer(characterEntity.getPlayerEntity().getId(),characterEntity.getHp(),( characterEntity).getPa()); //TODO DAMIEN : resourceHarverst ?
            }
            default: return null;
        }
    }

    public Building buildingEntityToBuilding (BuildingEntity buildingEntity)
    {
        switch (buildingEntity.getType())
        {
            case Constants.TYPE_BARRACKS :
            {
                return new Barracks(buildingEntity.getHp(),buildingEntity.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
            }

            case Constants.TYPE_FORUM :
            {
                return new Forum(buildingEntity.getHp(),buildingEntity.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
            }

            case Constants.TYPE_GRANARY :
            {
                return new Granary(buildingEntity.getHp(),buildingEntity.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
            }

            case Constants.TYPE_HOUSE :
            {
                return new House(buildingEntity.getHp(),buildingEntity.getPlayerEntity().getId(),null); //TODO : DAMIEN need to update with the DB update
            }
            default: return null;
        }
    }




    public EntityGame entityToEntityGame (Entity entity)
    {
        if (entity instanceof Character)
        {
          return characterToCharacterEntity((Character) entity);

        } else if (entity instanceof Resource)
        {
            return new ResourceEntity(entity.getHp(),Constants.TYPE_RESSOURCE,new PlayerEntity(),((Resource) entity).getResourceName().getType());

        } else if (entity instanceof Building)
        {
            return buildingToBuildingEntity((Building) entity);
        } else return null;
    }

    public CharacterEntity characterToCharacterEntity (Character character)
    {
        if (character instanceof Soldier) //TODO DAMIEN : how to insert the player ?
        {
            return new CharacterEntity(character.getHp(),Constants.TYPE_SOLDIER,new PlayerEntity(),((Soldier) character).getPa(),((Soldier) character).getPa(),((Soldier) character).getDamage() );
        } else if (character instanceof Farmer)
        {
            return new CharacterEntity(character.getHp(),Constants.TYPE_FARMER,new PlayerEntity(),((Farmer) character).getPa(),((Farmer) character).getPa(),null );
        } else return null;
    }

    public BuildingEntity buildingToBuildingEntity (Building building)
    {
        if (building instanceof House)
        {
            return new BuildingEntity(building.getHp(),Constants.TYPE_HOUSE,new PlayerEntity());
        } else if (building instanceof Forum)
        {
            return new BuildingEntity(building.getHp(),Constants.TYPE_FORUM,new PlayerEntity());
        } else if (building instanceof Barracks)
        {
            return new BuildingEntity(building.getHp(),Constants.TYPE_BARRACKS,new PlayerEntity());
        } else if (building instanceof Granary)
        {
            return new BuildingEntity(building.getHp(),Constants.TYPE_GRANARY,new PlayerEntity());
        } else return null; //TODO DAMIEN : Update the mapper default return by an Exception

    }

}
