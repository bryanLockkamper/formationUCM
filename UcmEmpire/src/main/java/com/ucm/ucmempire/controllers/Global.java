package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.dal.servicedal.BoardDalService;
import com.ucm.ucmempire.dal.servicedal.PlayerDalService;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Global {
    private Board board = new Board("test");
    private PlayerDalService playerDalService;
    private BoardDalService boardDalService;

    @Autowired
    Global(PlayerDalService playerDalService,BoardDalService boardDalService) {
        this.playerDalService = playerDalService;
        this.boardDalService = boardDalService;
    }

    @PostMapping("/move")
    public void move(@RequestBody List<Position> positions) {
        AStarService aStarService = new AStarService(board, positions.get(0), positions.get(1));
        Position position = aStarService.run(20);
        board.moveEntity(positions.get(0), position);
    }

    @GetMapping("/")
    public ArrayList<ArrayList<Square>> getBoard() {
        return board.getBoard();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PlayerDTOLogin playerDTO) {
        return ResponseEntity.ok().body(playerDalService.findByLoginAndPassword(playerDTO.getPseudo(), playerDTO.getPwd()));
    }

    @PostMapping("/register")
    public String register(@RequestBody PlayerDTORegister playerDTO) {
        System.out.println(playerDTO);
        return "200";
    }

    @GetMapping("/saveBoard")
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
}
