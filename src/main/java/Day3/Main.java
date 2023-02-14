package Day3;

/*Santa is delivering presents to an infinite two-dimensional grid of houses.

        He begins by delivering a present to the house at his starting location,
         and then an elf at the North Pole calls him via radio and tells him where to move next.
          Moves are always exactly one house to the north (^), south (v), east (>), or west (<).
          After each move, he delivers another present to the house at his new location.

        However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
         and Santa ends up visiting some houses more than once. How many houses receive at least one present?

        For example:

        > delivers presents to 2 houses: one at the starting location, and one to the east.
        ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
        ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.*/

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("day3.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        int c = 0;
        List<Character> moves = new ArrayList<>();
        HashMap<Point, Integer> hashMap = new HashMap<>();

        Point santaPosition = new Point(0, 0);
        Point roboSantaPosition = new Point(0,0);
        hashMap.put(santaPosition, 1);

        while ((c = reader.read()) != -1) {
            char character = (char) c;
            moves.add(character);
        }
        System.out.println("Moves: " + moves);

        int counter = 1;

        for (Character move :
                moves) {
            counter++;
            Point newPosition;
            if(counter % 2 == 0){
                //robo-santa move
                newPosition = move(move, roboSantaPosition);
                roboSantaPosition = newPosition;
            }else{
                //santa move
                newPosition = move(move, santaPosition);
                santaPosition = newPosition;
            }
            if (!hashMap.containsKey(newPosition)) {
                hashMap.put(newPosition, 1);
            } else {
                hashMap.put(newPosition, hashMap.get(newPosition) + 1);
            }
        }

        //How many houses receive at least one present?
        List<Point> collect = hashMap.entrySet().stream()
                .filter(x -> x.getValue() >= 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("How many houses receive at least one present? " + collect.size());

    }

    public static Point move(Character direction, Point actualPosition) {
        int x = actualPosition.x, y = actualPosition.y;
        switch (direction) {
            case '<':
                x = actualPosition.x - 1;
                break;
            case '>':
                x = actualPosition.x + 1;
                break;
            case '^':
                y = actualPosition.y + 1;
                break;
            case 'v':
                y = actualPosition.y - 1;
                break;
        }
        return new Point(x,y);
    }
}
