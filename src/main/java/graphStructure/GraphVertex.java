package graphStructure;

public class GraphVertex {

    private int distance;
    private int numberOfVertex;

    public GraphVertex(int distance, int numberOfVertex) {
        this.distance = distance;
        this.numberOfVertex = numberOfVertex;
    }

    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public void setNumberOfVertex(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
