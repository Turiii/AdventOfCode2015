package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static List<Integer> readDimensions(String input) {
        String[] split = input.split("x");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(a);
        integerList.add(b);
        integerList.add(c);
        return integerList;
    }

    private static int packPresentWithThePaper(List<Integer> dimensions) {

        //2*l*w + 2*w*h + 2*h*l
        int first = 2 * dimensions.get(0) * dimensions.get(1);
        int second = 2 * dimensions.get(0) * dimensions.get(2);
        int third = 2 * dimensions.get(1) * dimensions.get(2);
        int min = Math.min(first, Math.min(second, third)) / 2;

        return first + second + third + min;
    }

    private static int packPresentWithTheRibbon(List<Integer> dimensions) {
        dimensions.sort(null);
        int bow = dimensions.get(0) * dimensions.get(1) * dimensions.get(2);
        return 2 * (dimensions.get(0) + dimensions.get(1)) + bow;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("day2.txt");
        Scanner scanner = new Scanner(file);

        //total square feet of wrapping paper
        int totalOfPaper = 0;
        int totalOfRibbon = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            totalOfPaper += packPresentWithThePaper(readDimensions(line));
            totalOfRibbon += packPresentWithTheRibbon(readDimensions(line));
        }

        System.out.println("Total square feet of wrapping paper they should buy: " + totalOfPaper);
        System.out.println("Total of ribbon to wrap all presents: " + totalOfRibbon);

    }
}
