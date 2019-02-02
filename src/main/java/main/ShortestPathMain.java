package main;

import graphStructure.GraphMatrix;
import service.BestPathAlgorythm;

public class ShortestPathMain {

    private final BestPathAlgorythm bestPathAlgorythm;

    public ShortestPathMain(BestPathAlgorythm bestPathAlgorythm) {
        this.bestPathAlgorythm = bestPathAlgorythm;
    }

    public int getBestPath(GraphMatrix graphMatrix, int source, int distance) {
        return bestPathAlgorythm.getBestPath(graphMatrix, source, distance);
    }
}
