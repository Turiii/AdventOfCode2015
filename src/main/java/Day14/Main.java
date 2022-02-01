package Day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day14.txt");
        Scanner scanner = new Scanner(file);
        List<Comet> cometList = new ArrayList<>();
        HashMap<Comet, Integer> cometMap = new HashMap<>();
        while(scanner.hasNextLine()){
            String inputeLine = scanner.nextLine();
            String[] splitLine = inputeLine.split(" ");
            String name = splitLine[0];
            int speed = Integer.parseInt(splitLine[3]);
            int duration = Integer.parseInt(splitLine[6]);
            int rest = Integer.parseInt(splitLine[splitLine.length - 2]);
            Comet comet = new Comet(name, speed, duration, rest);
            int distance = comet.getDistance(2503);
            cometMap.put(comet,distance);
            System.out.println(comet + " " + distance);
        }
        String string = cometMap.toString();
        System.out.println(string);
        Integer max = Collections.max(cometMap.values());
        System.out.println(max);

    }
}
