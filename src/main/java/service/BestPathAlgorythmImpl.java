package service;

import exception.PathNoExists;
import graphStructure.GraphMatrix;
import graphStructure.GraphVertex;

import java.util.LinkedList;
import java.util.List;

public class BestPathAlgorythmImpl implements BestPathAlgorythm {

    private static final int NO_CONNECTION_BETWEEN_VERTEX = -1;
    private int[][] graph;
    private List<GraphVertex> vertex = new LinkedList<>();
    private List<Integer> shortestPathVertex = new LinkedList<>();

    @Override
    public int getBestPath(GraphMatrix graphMatrix, int source, int destination)
    {
        graph = graphMatrix.getGraph();

        if(source == destination)
            return 0;
        else
            return checkShortestPath(source, destination);
    }

    private int checkShortestPath(int first, int last)
    {
        setVertexDistances(vertex);

        int previousDistance = 0;

        while(shortestPathVertex.size() <= vertex.size())
        {
            shortestPathVertex.add(first);

            changeVertex(first, previousDistance);

            first = findShortestPath(shortestPathVertex, vertex);

//            previousDistance = previousDistance + 1;
//            System.out.println(previousDistance);

            previousDistance = vertex.get(first).getDistance();

        }

        int shortestPath = vertex.get(last).getDistance();
        isPathNoExist(shortestPath);

        return shortestPath;
    }

    private void setVertexDistances(List<GraphVertex> vertex)
    {
        for(int i = 0; i <= graph.length; i++)
        {
            vertex.add(new GraphVertex(Integer.MAX_VALUE, i));
        }
    }

    private void changeVertex(int selectedVertex, int previousDistance)
    {
        for (int j = 0; j < graph.length; j++)
        {

            if ((graph[selectedVertex][j] != NO_CONNECTION_BETWEEN_VERTEX) && (!shortestPathVertex.contains(j)))
            {
                for (GraphVertex v : vertex)
                {
                    int changeVertexDistance = graph[selectedVertex][j] + previousDistance;
//                    System.out.println(changeVertexDistance);
                    int getActualVertexDistance = v.getDistance();

                    boolean isDistanceGreaterThanActualDistance = changeVertexDistance > getActualVertexDistance;
                    if (v.getNumberOfVertex() == j && !isDistanceGreaterThanActualDistance)
                        v.setDistance(graph[selectedVertex][j] + previousDistance);
//                    System.out.println(v.getNumberOfVertex());
//                    System.out.println(v.getDistance());
                }
            }
        }
    }

    private int findShortestPath(List<Integer> edgeList, List<GraphVertex> vertexList)
    {
        int minDist = Integer.MAX_VALUE;
        int vertexNumber = 0;
        for(GraphVertex v : vertexList)
        {
            if(edgeList.contains(v.getNumberOfVertex()))
                continue;

            int distance = v.getDistance();
            if(distance < minDist)
            {
                minDist = distance;
                vertexNumber = v.getNumberOfVertex();
            }
        }

        return vertexNumber;
    }

    private void isPathNoExist(int result)
    {
        if(result == Integer.MAX_VALUE)
            throw new PathNoExists("Brak połączenia między wierzchołkami");
    }

}