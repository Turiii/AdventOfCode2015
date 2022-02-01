package Day6;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void turnOn(Light[][] lights, Point from, Point to) {
        for (int i = from.x; i <= to.x; i++) {
            for (int j = from.y; j <= to.y; j++) {
                lights[i][j].setState(true);
                lights[i][j].setBrightness(lights[i][j].getBrightness() + 1);
            }
        }
    }

    public static void turnOff(Light[][] lights, Point from, Point to) {
        for (int i = from.x; i <= to.x; i++) {
            for (int j = from.y; j <= to.y; j++) {
                lights[i][j].setState(false);
                if (lights[i][j].getBrightness() >= 1) {
                    lights[i][j].setBrightness(lights[i][j].getBrightness() - 1);
                }
            }
        }
    }

    public static void toggle(Light[][] lights, Point from, Point to) {
        for (int i = from.x; i <= to.x; i++) {
            for (int j = from.y; j <= to.y; j++) {
                lights[i][j].setBrightness(lights[i][j].getBrightness() + 2);
                if (lights[i][j].isState()) {
                    lights[i][j].setState(false);
                } else {
                    lights[i][j].setState(true);
                }
            }
        }
    }


    public static void resetLights(Light[][] lights) {
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[i][j] = new Light(new Point(i, j));
                lights[i][j].setState(false);
                lights[i][j].setBrightness(0);
            }
        }
    }

    public static Point makePoint(String line) {
        String[] split = line.split(",");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        return new Point(x, y);
    }


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("day6.txt");
        Scanner scanner = new Scanner(file);
        Light[][] lights = new Light[1000][1000];

        resetLights(lights);

        int sumOfTurnedOn = 0;
        int totalBrightness = 0;

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            String[] line = inputLine.split(" ");
            if (line[0].matches("turn")) {
                if (line[1].matches("on")) {
                    turnOn(lights, makePoint(line[2]), makePoint(line[4]));
                } else {
                    turnOff(lights, makePoint(line[2]), makePoint(line[4]));
                }
            } else {
                toggle(lights, makePoint(line[1]), makePoint(line[3]));
            }
        }

        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights.length; j++) {
                if (lights[i][j].isState()) {
                    sumOfTurnedOn += 1;
                }
                totalBrightness += lights[i][j].getBrightness();
            }
        }

        System.out.println("Sum of lights turned on: " + sumOfTurnedOn);
        System.out.println("Total brightness: " + totalBrightness);


    }
}

