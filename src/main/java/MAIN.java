import file.LoadGraph;
import main.ShortestPathMain;
import main.ShortestPathWithConvertMain;
import service.BestPathAlgorythmImpl;

public class MAIN {
    public static void main(String[] args)
    {
        ShortestPathMain shortestPath = new ShortestPathMain(new BestPathAlgorythmImpl());
        ShortestPathWithConvertMain shortestPathWithConvertMain = new ShortestPathWithConvertMain(shortestPath);

        int getShortestPath = shortestPathWithConvertMain.getBestPathAlgorythm("src/main/resources/test.txt", 2, 3);

        System.out.println(getShortestPath);
    }
}
