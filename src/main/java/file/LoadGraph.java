package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class LoadGraph {

    private final static String DELIMITER = Pattern.compile("\\s+|,\\s*|\\.\\s*").pattern();

    public static List<String[]> loadGraphMatrix(String filename){
        List<String[]> rowData = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(DELIMITER);
                rowData.add(row);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return rowData;
    }
}
