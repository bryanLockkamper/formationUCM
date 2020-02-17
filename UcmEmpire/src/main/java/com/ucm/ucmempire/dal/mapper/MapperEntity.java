package com.ucm.ucmempire.dal.mapper;

import com.ucm.ucmempire.dal.entity.*;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.biomes.BiomeFactory;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.*;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperEntity {

    private Mapper mapper = new DozerBeanMapper();


    public BoardEntity boardToBoardEntity (Board board)
    {
      return mapper.map(board,BoardEntity.class);
    }


    public Board boardEntityToBoard (BoardEntity boardEntity)
    {
        return mapper.map(boardEntity,Board.class);
    }

    public Square squareEntityToSquare (SquareEntity squareEntity)
    {

        BiomeFactory biomeFactory = new BiomeFactory(); //TODO DAMIEN : need to declare in the swagger the right string to insert into the square

        if (squareEntity.isSpecial())
        {
            return mapper.map(squareEntity,SpecialSquare.class); //TODO DAMIEN : attention biome and not working
           // return new SpecialSquare(/* entityToEntityGame(squareEntity.getContents) */,squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
        } else
        {
            return new Square(entityGameToEntity(squareEntity.getContents().get(0).getEntityGame()),squareEntity.isBuildable(),squareEntity.isWalkable(),BiomeType.valueOf(squareEntity.getBiome()));
        }

    }

    public Entity entityGameToEntity (EntityGame entityGame)
    {
        if (entityGame instanceof CharacterEntity)
        {
            switch (entityGame.getType())
            {
                case Constants.TYPE_SOLDIER :
                {
                    return mapper.map(entityGame,Soldier.class);
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


    public Player playerEntityToPlayer (PlayerEntity playerEntity)
    {
        Player player = new Player();
        player.setId(playerEntity.getId());
        player.setName(playerEntity.getLastName());

        List<Entity> entityList = playerEntity.getEntityGamesList().stream()
                .filter(e -> !(e instanceof ResourceEntity) )
                .map(data -> entityGameToEntity(data))
                .collect(Collectors.toList());

        player.setEntities(entityList);

        Set<Resource> resourceSet = playerEntity.getEntityGamesList().stream()
                .filter(e -> (e instanceof ResourceEntity) )
                .map(data -> entityGameToEntity(data))
                
                .collect(Collectors.toList());

        player.setResources();

        return mapper.map(playerEntity,Player.class);
    }

    public PlayerEntity playerToPlayerEntity (Player player)
    {

        return mapper.map(player,PlayerEntity.class);
    }

}
