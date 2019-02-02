import exception.PathNoExists;
import graphStructure.GraphMatrix;
import main.ShortestPathMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.BestPathAlgorythm;
import service.BestPathAlgorythmImpl;

public class ShortestPathMainTest {
    private BestPathAlgorythm bestPathAlgorythm = new BestPathAlgorythmImpl();
    private ShortestPathMain shortestPathMain = new ShortestPathMain(bestPathAlgorythm);
    private int[][] graph;
    private GraphMatrix graphMatrix;

    @Before
    public void init(){
        graph = new int[][]{
                {-1, 3, -1, 9, 5},
                {11, 4, 5, -1, -1},
                {-1, 5, -1, -1, 1},
                {8, -1, 10, -1, -1},
                {5, -1, -1, 6, -1}
        };

        graphMatrix = new GraphMatrix(graph);
    }

    @Test(expected = PathNoExists.class)
    public void pathNoExistsTest(){
        final int[][] graphM = new int[][]{
                {-1, 3, -1, 11, 5},
                {-1, -1, 5, -1, -1},
                {-1, 5, -1, -1, 1},
                {11, -1, -1, -1, -1},
                {5, 1, -1, 1, -1}
        };

        shortestPathMain.getBestPath(new GraphMatrix(graphM), 2, 3);
        shortestPathMain.getBestPath(new GraphMatrix(graphM), 3, 2);
    }

    @Test
    public void isSourceDestinationTest(){
        final int result = shortestPathMain.getBestPath(graphMatrix, 1,1);

        Assert.assertEquals(result, 0);
    }

    @Test
    public void checkResultOK(){
        final int result = shortestPathMain.getBestPath(graphMatrix, 0, 3);

        Assert.assertEquals(result, 9);
    }

    @Test
    public void checkResultNotOK(){
        final int result = shortestPathMain.getBestPath(graphMatrix, 0, 3);

        Assert.assertNotEquals(result, 20);
    }
}
