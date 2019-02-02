package service;

import graphStructure.GraphMatrix;

public interface BestPathAlgorythm {
    int getBestPath(GraphMatrix graphMatrix, int source, int destination);
}
