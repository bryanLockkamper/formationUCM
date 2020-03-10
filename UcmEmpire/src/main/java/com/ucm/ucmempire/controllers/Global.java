package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import com.ucm.ucmempire.dal.entity.EntityGame;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.entity.ResourceEntity;
import com.ucm.ucmempire.dal.entity.SquareEntity;
import com.ucm.ucmempire.dal.mapper.MapperPlayer;
import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.dal.servicedal.BoardDalService;
import com.ucm.ucmempire.dal.servicedal.PlayerDalService;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.dto.CellDTO;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import com.ucm.ucmempire.models.dto.PlayerDTORess;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.dto.*;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import com.ucm.ucmempire.models.units.unitInterfaces.IFarmer;
import com.ucm.ucmempire.services.CombatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//ajouter une description pour chaque API grâce à l'annotation  @Api
@Api(value = "API pour es opérations CRUD sur les produits.")
@RestController
@CrossOrigin
public class Global {
    private Board board = new Board("initBoard") ;
    Player p1 ;
    Player p2 = new Player(0, "gerard");
    private PlayerDalServiceImpl playerDalService;
    private Game game;
    private BoardDalService boardDalService;
    private MapperPlayer mapperPlayer;

    @Autowired
    Global(PlayerDalServiceImpl playerDalService,BoardDalService boardDalService) {
        this.playerDalService = playerDalService;
        this.boardDalService = boardDalService;
        this.mapperPlayer = mapperPlayer;
    }

    @PostMapping("/attack")
    public void attack(@RequestBody List<CellDTO> cellDTOS) {
        Position first = new Position(cellDTOS.get(0).getRowId(), cellDTOS.get(0).getId());
        Position second = new Position(cellDTOS.get(1).getRowId(), cellDTOS.get(1).getId());
        if (CombatService.fight((Soldier) (board.getBoard().get(first.getX()).get(first.getY()).getContent()), (Soldier) board.getBoard().get(second.getX()).get(second.getY()).getContent())) {
            board.getBoard().get(second.getX()).get(second.getY()).setContent(null);
        }
    }

    //définir une description pour chaque opération /méthode à l'aide de l'annotation@ApiOperation
    @ApiOperation(value = "Appelé a chaque fois qu'un joueurs bouge une unité")
    @PostMapping("/move")
    public void move(@RequestBody List<CellDTO> cellDTOS) {
        Position first = new Position(cellDTOS.get(0).getRowId(), cellDTOS.get(0).getId());
        Position second = new Position(cellDTOS.get(1).getRowId(), cellDTOS.get(1).getId());
        AStarService aStarService = new AStarService(board, first, second);

        Character character;
        Entity entity = board.getBoard().get(cellDTOS.get(0).getRowId()).get(cellDTOS.get(0).getId()).getContent();
        if (entity instanceof Resource) {
            character = ( (SpecialSquare) board.getBoard().get(cellDTOS.get(0).getRowId()).get(cellDTOS.get(0).getId())).getFarmers().get(0);
            ((SpecialSquare) board.getBoard().get(cellDTOS.get(0).getRowId()).get(cellDTOS.get(0).getId())).getFarmers().remove(0);
        } else {
            character = (Character) entity;
        }


        PositionDTO position = aStarService.run(character.getPa());
        character.move(position);
        if (character instanceof Farmer && character.getPa() > 0 && board.getBoard().get(cellDTOS.get(1).getRowId()).get(cellDTOS.get(1).getId()).getContent() instanceof Resource) {
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


        //Préparer la case en cours et les cases adjacentes pour la boucle pour mettre l'api à jour
        Square before = board.getBoard().get(cellDTOS.get(0).getRowId()).get(cellDTOS.get(0).getId());
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

    @ApiOperation(value = "Appelé au début d'une nouvelle partie pour avoir un nouveau le board")
    @GetMapping("/newBoard")
    public ArrayList<ArrayList<SquareDTO>> getNewBoard() {
        this.board = new Board("PlainBoard");
        this.p2 = new Player(0,"Toto");

            p1.addEntity(new Soldier(p1.getId()));
            p1.addEntity(new Soldier(p1.getId()));
            p1.addEntity(new Farmer(p1.getId()));
            p2.addEntity(new Soldier(p2.getId()));
            board.setSquare(new Position(0, 0), p1.getEntity(3));
            board.setSquare(new Position(10, 5), p1.getEntity(4));
            board.setSquare(new Position(0, 5), p1.getEntity(5));
            board.setSquare(new Position(3, 2), p2.getEntity(3));


        return new BoardDTO(board).getSquareDTOList();
    }

    @ApiOperation(value = "Appelé au début de chaque tour pour avoir tout le board")
    @GetMapping("/")
    public ArrayList<ArrayList<SquareDTO>> getBoard() {

        return new BoardDTO(board).getSquareDTOList();
    }

    @ApiOperation(value = "Appelé a chaque fois qu'un joueurs voudra ce loger")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PlayerDTOLogin playerDTO) {
        Optional<PlayerEntity> player = playerDalService.findByLoginAndPassword(playerDTO.getPseudo(), playerDTO.getPassword());
        if (player.isPresent()) {
            p1 = new Player(player.get().getId(), player.get().getLogin());
            game = new Game(p1, p2, board);
            return ResponseEntity.ok().body(player.get());
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ApiOperation(value = "Appelé a chaque fois qu'un joueurs voudrat s'enregistrer")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PlayerDTORegister playerDTO) {

        PlayerEntity playerEntity = new PlayerEntity(playerDTO.getLastname(), playerDTO.getFirstname(), playerDTO.getPseudo(), playerDTO.getPassword());
        playerDalService.save(playerEntity);

        System.out.println(playerEntity.getId() + playerEntity.getLogin());
        p1 = new Player(playerEntity.getId(), playerEntity.getLogin());


        return ResponseEntity.ok("200");
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
        return true;
    }

    @GetMapping("/saveBoard") //TODO DAMIEN : WIP
    public void saveBoard ()
    {

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

        Optional<PlayerEntity> p = playerDalService.findById(id);

        PlayerDTORess pldto = new PlayerDTORess();
        pldto.setUser_id(p.get().getId());

        pldto.setResources(p.get().getEntityGamesList().stream()
                .filter(entityGame -> entityGame instanceof ResourceEntity)
                .map(entityGame -> (ResourceEntity) entityGame)
                .collect(Collectors.toList()));

        System.out.println(pldto.toString() + " TOTO MARCHE");
        return ResponseEntity.ok(pldto);
    }

    @GetMapping("/player/haslost")
    public ResponseEntity<List<PlayerHasLostDTO>> isHasLost(ArrayList<PlayerHasLostDTO> players)
    {
        List<PlayerHasLostDTO> playerHasLostDTOList = new ArrayList<>();

//        for (int i = 0; i < players.size(); i++) {
//
//            Optional<PlayerEntity> p = playerDalService.findById(players.get(i).getPlayer_id());
//
//            Player player = mapperPlayer.playerEntityToPlayer(p.get());
//
//            PlayerHasLostDTO playerHasLostDTO = mapperPlayer.playerToPlayerHasLostDTO(player);
//
//            playerHasLostDTOList.add(playerHasLostDTO);
//        }

        playerHasLostDTOList.add(mapperPlayer.playerToPlayerHasLostDTO(p2));
        playerHasLostDTOList.add(mapperPlayer.playerToPlayerHasLostDTO(p1));

        System.out.println(p2.isHasLost());

        return ResponseEntity.ok(playerHasLostDTOList);
    }
}
