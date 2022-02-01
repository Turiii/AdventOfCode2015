package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day1.txt");
        Scanner scanner = new Scanner(file);
        String input = scanner.next();

        //starting position
        int position = 0;

        //position of the character that causes Santa to first enter the basement
        int indexOfCommand = 0;

        for (int i = 0; i < input.length(); i++) {
            if (position == -1 && indexOfCommand == 0){
                indexOfCommand = i;
            }
            if(input.charAt(i) == '('){
                position += 1;
            }
            if(input.charAt(i) == ')'){
                position -= 1;
            }

        }
        System.out.println("Position after all commands: " + position);
        System.out.println("Position of the commands that cause Santa to enter the basement for the first time: " + indexOfCommand);

    }
}
