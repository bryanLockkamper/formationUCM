package controllers.pathfinding;

import models.Entity;
import models.boardPackage.Board;
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

   /* @Test //TODO : BRYAN
    public void run_start00_end55_pa20_55() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,5), aStarService.run(20));
    }

    @Test
    public void run_start00_end55_pa2_20() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(2,0), aStarService.run(2));
    }

    @Test
    public void run_start00_end55_pa0_00() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(0,0), aStarService.run(0));
    }

    @Test
    public void run_start00_end32_pa5_32() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(3,2), aStarService.run(5));
    }

    @Test
    public void run_withFullStartObstacle_start00_end32_pa5_32() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        board.getBoard().get(1).get(0).setWalkable(false);
        board.getBoard().get(0).get(1).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(0,0), aStarService.run(5));
    }

    @Test
    public void run_withObstacle_start00_end55_pa5_00() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        board.getBoard().get(3).get(2).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(3,2));
        Assert.assertEquals(new Position(0,0), aStarService.run(5));
    }

    @Test
    public void run_withObstacle_start00_end55_pa10_55() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        board.getBoard().get(4).get(5).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,5), aStarService.run(10));
    }

    @Test
    public void run_withObstacle_start00_end55_pa5_55() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        board.getBoard().get(4).get(5).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
        Assert.assertEquals(new Position(5,0), aStarService.run(5));
    }

    @Test
    public void run_withFullFinishObstacle_start00_end55_pa10_00() {
        runWithFullFinish();
        Assert.assertEquals(new Position(0,0), aStarService.run(10));
    }

    @Test
    public void run_withFullFinishObstacle_start00_end55_pa5_00() {
        runWithFullFinish();
        Assert.assertEquals(new Position(0,0), aStarService.run(5));
    }

    private void runWithFullFinish() {
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        board.getBoard().get(4).get(5).setWalkable(false);
        board.getBoard().get(5).get(4).setWalkable(false);
        aStarService = new AStarService(board, new Position(0,0), new Position(5,5));
    }*/
}