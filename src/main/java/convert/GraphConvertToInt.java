package convert;

import file.LoadGraph;
import graphStructure.GraphMatrix;

import java.util.List;

public class GraphConvertToInt {

    private static GraphConvertToInt instance;

    public GraphConvertToInt() {
        if(instance != null)
            throw new IllegalStateException("Cannot create new instance, use getInstance method instead");
    }

    public static GraphConvertToInt getInstance(){
        if(instance == null)
            instance = new GraphConvertToInt();

        return instance;
    }

    public GraphMatrix convertMatrix(String filename)
    {
        List<String[]> rowsData = LoadGraph.loadGraphMatrix(filename);
        int[][] matrix = parseToInteger(rowsData);

        return new GraphMatrix(matrix);
    }

    private int[][] parseToInteger(List<String[]> rows)
    {
        int[][] matrix = new int[rows.size()][rows.size()];

        for(int row = 0; row < matrix.length; row++)
        {
            String[] line = rows.get(row);
            for (int col = 0; col < matrix[row].length; col++)
            {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        return matrix;
    }
}
