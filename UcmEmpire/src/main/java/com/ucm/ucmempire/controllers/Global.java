package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.entity.ResourceEntity;
import com.ucm.ucmempire.dal.mapper.MapperPlayer;
import com.ucm.ucmempire.dal.servicedal.BoardDalService;
import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.Barracks;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.buildings.ProdBuilding;
import com.ucm.ucmempire.models.dto.*;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import com.ucm.ucmempire.services.CombatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.*;
import java.util.stream.Collectors;

//ajouter une description pour chaque API grâce à l'annotation  @Api
@Api(value = "API pour es opérations CRUD sur les produits.")
@RestController
@CrossOrigin
public class Global {
    private Board board = new Board("initBoard");
    Player p1;
    Player p2 = new Player(0, "gerard");
    Player p;
    private PlayerDalServiceImpl playerDalService;
    private Game game;
    private BoardDalService boardDalService;
    private MapperPlayer mapperPlayer;

    @Autowired
    Global(PlayerDalServiceImpl playerDalService, BoardDalService boardDalService) {
        this.playerDalService = playerDalService;
        this.boardDalService = boardDalService;
        mapperPlayer = new MapperPlayer();
    }

    @PostMapping("/attack")
    public void attack(@RequestBody List<CellDTO> cellDTOS) {
        Position first = new Position(cellDTOS.get(0).getRowId(), cellDTOS.get(0).getId());
        Position second = new Position(cellDTOS.get(1).getRowId(), cellDTOS.get(1).getId());
        AStarService aStarService = new AStarService(board, first, second);
        Soldier attack = (Soldier) (board.getBoard().get(first.getX()).get(first.getY()).getContent());
        PositionDTO positionDTO = aStarService.run(attack.getPa());
        if (positionDTO.getPosition().getX() + 1 == second.getX()
            || positionDTO.getPosition().getX() - 1 == second.getX()
            || positionDTO.getPosition().getY() + 1 == second.getY()
            || positionDTO.getPosition().getY() - 1 == second.getY()
        ) {
            if (CombatService.fight(attack, board.getBoard().get(second.getX()).get(second.getY()).getContent())) {
                board.getBoard().get(second.getX()).get(second.getY()).setContent(null);

            }
            attack.setPa(attack.getPa() - (positionDTO.getPa() + 1));
        }
    }

    //définir une description pour chaque opération /méthode à l'aide de l'annotation@ApiOperation
    @ApiOperation(value = "Appelé a chaque fois qu'un joueurs bouge une unité")
    @PostMapping("/move")
    public void move(@RequestBody List<CellDTO> cellDTOS) {
        Position first = new Position(cellDTOS.get(0).getRowId(), cellDTOS.get(0).getId());
        Position second = new Position(cellDTOS.get(1).getRowId(), cellDTOS.get(1).getId());
        AStarService aStarService = new AStarService(board, first, second);

        Character character = null;
        Entity entity = board.getSquare(cellDTOS.get(0)).getContent();
        if (entity instanceof Resource) {
            character = ((SpecialSquare) board.getSquare(cellDTOS.get(0))).getFarmers().get(0);
            ((SpecialSquare) board.getSquare(cellDTOS.get(0))).getFarmers().remove(0);
        } else if (entity instanceof ProdBuilding) {
            character = (Character) ((ProdBuilding) entity).getEntities().get(0);
            ((ProdBuilding) entity).getEntities().remove(0);
        } else {
            character = (Character) entity;
        }

        if (character.getPa() == 0)
            character.setMoveLeft(second);
        else {
            PositionDTO position = aStarService.run(character.getPa());
            character.move(position);
            if (character instanceof Farmer && character.getPa() > 0 && board.getSquare(cellDTOS.get(1)).getContent() instanceof Resource) {
                board.moveEntity(first, second);
                character.setMoveLeft(second);
            } else {
                board.moveEntity(first, position.getPosition());
                if (position.getPosition().equals(second)) {
                    character.setMoveLeft(null);
                } else {
                    character.setMoveLeft(second);
                }
                board.getBoard().get(position.getPosition().getX()).get(position.getPosition().getY()).setContent(character);
            }
        }


        //Préparer la case en cours et les cases adjacentes pour la boucle pour mettre l'api à jour
        Square before = board.getSquare(cellDTOS.get(0));
        Square after;

        //Désactive le brouillard sur la case où se tient le personnage
        before.setOverlayed(false);

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int i = first.getX();
                int j = first.getY();
                if ((i + x >= 0 && j + y >= 0)
                        && (i + x < board.getBoard().size() && j + y < board.getBoard().size())
                ) {
                    after = board.getBoard().get(cellDTOS.get(0).getRowId() + x).get(cellDTOS.get(0).getId() + y);
                    after.setOverlayed(false);
                }
            }
        }
    }

    @ApiOperation(value = "Appelé a chaque fois qu'une unité d'un joueur meurt")
    @PostMapping("/deathEntity")
    public void deathEntity(@RequestBody CellDTO cellDTO) {
        board.setSquare(new Position(cellDTO.getRowId(), cellDTO.getId()), null);
    }

    @ApiOperation(value = "Appelé au début d'une nouvelle partie pour avoir un nouveau board")
    @PostMapping("/newBoard")
    public ArrayList<ArrayList<SquareDTO>> getNewBoard(@RequestBody List<String> usernames) {

        List<Player> players = usernames.stream().map(data -> mapperPlayer.playerEntityToPlayer(Objects.requireNonNull(playerDalService.findByLogin(data).orElse(null)))).collect(Collectors.toList());

        this.board = new Board("PlainBoard");
        this.p2 = new Player(0,"Toto");
        p1 = players.get(0); //TODO : Need to change to accept multi players

            p1.addEntity(new Soldier(p1.getId()));
            p1.addEntity(new Soldier(p1.getId()));
            p1.addEntity(new Farmer(p1.getId()));
            p2.addEntity(new Soldier(p2.getId()));
            board.setSquare(new Position(0, 0), p1.getEntity(3));
            board.setSquare(new Position(10, 5), p1.getEntity(4));
            board.setSquare(new Position(0, 5), p1.getEntity(5));
            board.setSquare(new Position(3, 2), p2.getEntity(3));

        game = new Game(p1, p2, board);
        return new BoardDTO(board).getSquareDTOList();
    }

    @ApiOperation(value = "Appelé au début de chaque tour pour avoir tout le board")
    @GetMapping("/")
    public ArrayList<ArrayList<SquareDTO>> getBoard() {

        return new BoardDTO(board).getSquareDTOList();
    }


    @ApiOperation(value = "Appelé au début de chaque tour")
    @GetMapping("/timer/start")
    public boolean start() {
        if (game.nextRound()) {
            this.game.run();
            return true;
        }
        return false;
    }

    @ApiOperation(value = "Appelé a la fin de chaque tour")
    @GetMapping("/timer/stop")
    public boolean stop() {
        synchronized (game) {
            game.notify();
        }
        if (p.getId() == p1.getId())
            p = p2;
        else
            p = p1;
        return true;
    }

    @GetMapping("/saveBoard") //TODO DAMIEN : WIP
    public void saveBoard() {

        System.out.println(board.getBoard().get(0).get(0).getBiome());
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);

        //Etape 1 save the board
        System.out.println(boardDalService.save(board));

        //Etape 2 update the player table
        // playerDalService.saveBoard(idList,boardEntity);


    }

    @GetMapping("/player/res/{id}")
    public ResponseEntity<PlayerDTORess> getRess(@PathVariable("id") Integer id) {


        PlayerDTORess pldto = new PlayerDTORess((id == p1.getId()? p1.getResources() : p2.getResources())
                .stream()
                .map(resource -> new ResourceDTO(resource.getHp(), resource.getNameOfRessource()))
                .collect(Collectors.toList()));

        return ResponseEntity.ok(pldto);
    }

    @GetMapping("/player/haslost")
    public ResponseEntity<List<PlayerHasLostDTO>> isHasLost(ArrayList<PlayerHasLostDTO> players) {
        List<PlayerHasLostDTO> playerHasLostDTOList = new ArrayList<>();
        playerHasLostDTOList.add(mapperPlayer.playerToPlayerHasLostDTO(p2));
        playerHasLostDTOList.add(mapperPlayer.playerToPlayerHasLostDTO(p1));
        return ResponseEntity.ok(playerHasLostDTOList);
    }

    @PostMapping("/createFarmer")
    public void createFarmer(@RequestBody CellDTO cellDTO) {
        Forum forum = (Forum) board.getSquare(cellDTO).getContent();
        Farmer farmer = new Farmer(forum.getIdUser());
        Resource playerRes = p.getResource(ResourceName.FOOD);
        int farmerRequirement = farmer.getRequirement(ResourceName.FOOD).getHp();
        if (playerRes.getHp() >= farmerRequirement) {
            forum.product(farmer);
            playerRes.setHp(playerRes.getHp() - farmerRequirement);
        }
    }

    @PostMapping("/createBarrack")
    public void createBarrack(@RequestBody List<CellDTO> cellDTOS) {
        Barracks barracks = new Barracks(((Farmer) board.getSquare(cellDTOS.get(0)).getContent()).getIdUser());
        if (p.getResource(ResourceName.FOOD).getHp() >= barracks.getRequirement(ResourceName.FOOD).getHp()
                && p.getResource(ResourceName.STONE).getHp() >= barracks.getRequirement(ResourceName.STONE).getHp()
                && p.getResource(ResourceName.WOOD).getHp() >= barracks.getRequirement(ResourceName.WOOD).getHp()) {
            board.getSquare(cellDTOS.get(1)).setContent(new Barracks(p.getId()));
            p.getResource(ResourceName.FOOD).setHp(p.getResource(ResourceName.FOOD).getHp() - barracks.getRequirement(ResourceName.FOOD).getHp());
            p.getResource(ResourceName.WOOD).setHp(p.getResource(ResourceName.WOOD).getHp() - barracks.getRequirement(ResourceName.WOOD).getHp());
            p.getResource(ResourceName.STONE).setHp(p.getResource(ResourceName.STONE).getHp() - barracks.getRequirement(ResourceName.STONE).getHp());
        }

    }

    @PostMapping("/createSoldier")
    public void createSoldier(@RequestBody CellDTO cellDTO) {
        Barracks barracks = (Barracks) board.getSquare(cellDTO).getContent();
        Farmer farmer = new Farmer(barracks.getIdUser());
        Resource playerRes = p.getResource(ResourceName.FOOD);
        int farmerRequirement = farmer.getRequirement(ResourceName.FOOD).getHp();
        if (playerRes.getHp() >= farmerRequirement) {
            barracks.product(new Soldier(barracks.getIdUser()));
            playerRes.setHp(playerRes.getHp() - farmerRequirement);
        }
    }
}
