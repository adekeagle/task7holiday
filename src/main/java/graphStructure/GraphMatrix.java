package graphStructure;

public class GraphMatrix {

    private int[][] graph;

    public GraphMatrix(int[][] graph) {
        this.graph = graph;
    }

    public int[][] getGraph() {
        return this.graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
}
