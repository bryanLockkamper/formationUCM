package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.controllers.pathfinding.PositionDTO;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.dto.CellDTO;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class Global {
    private Board board = new Board("test");
    Player p1 = new Player(0, "jean");
    Player p2 = new Player(1, "gerard");
    private PlayerDalServiceImpl playerDalService;
    private Player player1;
    private Game game = new Game();

    @Autowired
    Global(PlayerDalServiceImpl playerDalService) {
        this.playerDalService = playerDalService;
    }

    @PostMapping("/move")
    public void move(@RequestBody List<CellDTO> cellDTOS) {
        Position first = new Position(cellDTOS.get(0).getRowId(), cellDTOS.get(0).getId());
        Position second = new Position(cellDTOS.get(1).getRowId(), cellDTOS.get(1).getId());
        AStarService aStarService = new AStarService(board, first, second);
        Character character = (Character) board.getBoard().get(cellDTOS.get(0).getRowId()).get(cellDTOS.get(0).getId()).getContent();
        PositionDTO position = aStarService.run(character.getPa());
        board.moveEntity(first, position.getPosition());
        character.move(position);
        if (position.getPosition().equals(second))
            position.setPosition(null);
        else
            position.setPosition(second);
        character.setMoveLeft(position.getPosition());

        // TODO: 17-02-20 return entityDTO ?
    }

    @PostMapping("/deathEntity")
    public void deathEntity(@RequestBody CellDTO cellDTO) {
        System.out.println(cellDTO);
        board.setSquare(new Position(cellDTO.getRowId(), cellDTO.getId()), null);
        Position position = aStarService.run(20);
        board.moveEntity(first, position);
        return board.getBoard();
    }

    @GetMapping("/")
    public ArrayList<ArrayList<Square>> getBoard() {
        if (p1.getEntities().size() == 0) {
            p1.addEntity(new Soldier(0));
            p1.addEntity(new Soldier(0));
            p1.addEntity(new Farmer(0));
            p2.addEntity(new Soldier(1));
            board.setSquare(new Position(0,0), p1.getEntity(0));
            board.setSquare(new Position(10,5), p1.getEntity(1));
            board.setSquare(new Position(0,5), p1.getEntity(2));
            board.setSquare(new Position(3,2), p2.getEntity(0));
        }

        return board.getBoard();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PlayerDTOLogin playerDTO) {
        Optional<PlayerEntity> player = playerDalService.findByLoginAndPassword(playerDTO.getPseudo(), playerDTO.getPwd());
        if (player.isPresent()){
            player1 = new Player(player.get().getId() , player.get().getLogin());
            return ResponseEntity.ok().body(player.get());
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PlayerDTORegister playerDTO) {

        PlayerEntity playerEntity = new PlayerEntity(playerDTO.getLastname(), playerDTO.getFirstname() , playerDTO.getPseudo() , playerDTO.getPassword());
        playerDalService.save(playerEntity);

        System.out.println(playerEntity.getId() + playerEntity.getLogin());
        player1 = new Player(playerEntity.getId() , playerEntity.getLogin());


        return ResponseEntity.ok("200");
    }

    @GetMapping("/timer/start")
    public boolean start ()
    {
        this.game.setPlayer1(player1);
        this.game.run();
        return true;
    }

    @GetMapping("/timer/stop")
    public boolean stop ()
    {
        this.game.nextRound();
        return true;
    }
}
