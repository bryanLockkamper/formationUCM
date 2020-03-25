package com.ucm.ucmempire;

import com.ucm.ucmempire.controllers.pathfinding.AStarService;
import com.ucm.ucmempire.controllers.pathfinding.Position;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.boardPackage.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AStarServiceTest {

    Board board;
    AStarService aStarService;
    @Before
    public void setUp() throws Exception {
        board = new Board("test");
    }

    @Test
    public void run_start00_end55_pa20_55() {
        board.setSquare(new Position(0,0), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,5), aStarService.run(20).getPosition());
    }

    @Test
    public void run_start00_end55_pa20_endIsOccupe_00() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.setSquare(new Position(5,5), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,4), aStarService.run(20).getPosition());
    }

    @Test
    public void run_start00_end55_pa2_20() {
        board.setSquare(new Position(0,0), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(2,0), aStarService.run(2).getPosition());
    }

    @Test
    public void run_start00_end55_pa0_00() {
        board.setSquare(new Position(0,0), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(0,0), aStarService.run(0).getPosition());
    }

    @Test
    public void run_start00_end32_pa5_32() {
        board.setSquare(new Position(0,0), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(3,2), aStarService.run(5).getPosition());
    }

    @Test
    public void run_withFullStartObstacle_start00_end32_pa5_32() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.getBoard().get(1).get(0).setWalkable(false);
        board.getBoard().get(0).get(1).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(0,0), aStarService.run(5).getPosition());
    }

    @Test
    public void run_withObstacle_start00_end55_pa5_00() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.getBoard().get(3).get(2).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(3,1), aStarService.run(5).getPosition());
    }

    @Test
    public void run_withObstacle_start00_end55_pa10_55() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.getBoard().get(4).get(5).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,5), aStarService.run(10).getPosition());
    }

    @Test
    public void run_withObstacle_start00_end55_pa5_55() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.getBoard().get(4).get(5).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,0), aStarService.run(5).getPosition());
    }

    @Test
    public void run_withFullFinishObstacle_start00_end55_pa10_00() {
        runWithFullFinish();
        Assert.assertEquals(new Position(5,3), aStarService.run(10).getPosition());
    }

    @Test
    public void run_withFullFinishObstacle_start00_end55_pa5_00() {
        runWithFullFinish();
        Assert.assertEquals(new Position(0,0), aStarService.run(5).getPosition());
    }

    private void runWithFullFinish() {
        board.setSquare(new Position(0,0), new Entity(20));
        board.getBoard().get(4).get(5).setWalkable(false);
        board.getBoard().get(5).get(4).setWalkable(false);
        board.getBoard().get(5).get(6).setWalkable(false);
        board.getBoard().get(6).get(5).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
    }

    @Test
    public void run_start00_end00_pa5_00() {
        board.setSquare(new Position(0,0), new Entity(20));
        aStarService = new AStarService(board, new Position(0,0), new Position(0,0));
        Assert.assertEquals(new Position(0,0), aStarService.run(5).getPosition());
    }

    @Test
    public void run__start55_end00_pa10_00() {
        board.setSquare(new Position(5,5), new Entity(20));
        aStarService = new AStarService(board, new Position(5,5), new Position(0,0));
        Assert.assertEquals(new Position(0,0), aStarService.run(10).getPosition());
    }
}