package main;

import convert.GraphConvertToInt;
import graphStructure.GraphMatrix;

public class ShortestPathWithConvertMain {

    private final ShortestPathMain shortestPathMain;
    private GraphConvertToInt graphConvertToInt = GraphConvertToInt.getInstance();

    public ShortestPathWithConvertMain(ShortestPathMain shortestPathMain) {
        this.shortestPathMain = shortestPathMain;
    }

    public int getBestPathAlgorythm(String filename, int source, int destination) {
        GraphMatrix graphMatrix = graphConvertToInt.convertMatrix(filename);
        return shortestPathMain.getBestPath(graphMatrix, source, destination);
    }

}
