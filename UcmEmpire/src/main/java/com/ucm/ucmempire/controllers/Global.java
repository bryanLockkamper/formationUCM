package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.dto.PlayerDTOLogin;
import com.ucm.ucmempire.models.dto.PlayerDTORegister;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Global {
    Board board = new Board("test");
//    private UserService userService;

//    @Autowired
//    Global(UserService userService) {
//        this.userService = userService;
//    }

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
    public String login(@RequestBody PlayerDTOLogin playerDTO) {
        // TODO: 11-02-20 request playerService to login and return token
        System.out.println(playerDTO);
        return null;
    }

    @PostMapping("/register")
    public String register(@RequestBody PlayerDTORegister playerDTO) {
        // TODO: 11-02-20 request playerService to register and return token
        System.out.println(playerDTO);
        return null;
    }
}
