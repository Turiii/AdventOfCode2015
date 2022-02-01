package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static boolean threeVowels(String line) {
        char[] chars = line.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean twiceInARow(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) == line.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContain(String line) {
        boolean state = true;
        if (line.contains("ab")) {
            state = false;
        }
        if (line.contains("cd")) {
            state = false;
        }
        if (line.contains("pq")) {
            state = false;
        }
        if (line.contains("xy")) {
            state = false;
        }
        return state;
    }

    public static boolean isNice(String linia) {
        return isContain(linia) && threeVowels(linia) && twiceInARow(linia);
    }

    public static boolean ABA(String linia) {
        char[] slowo = linia.toCharArray();
        for (int i = 0; i < slowo.length - 2; i++) {
            if (slowo[i] == slowo[i + 2]) {
                return slowo[i + 1] != slowo[i];
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File plik = new File("D:\\AdventOfCode2015\\src\\main\\java\\Day5\\day1.txt");
        Scanner skaner = new Scanner(plik);
        int count1 = 0;
        int count2 = 0;
        final String regex = "^.*?([a-z]{2}).*?(\\1).*$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);


        while (skaner.hasNext()) {
            String linia_pobrana = skaner.nextLine();
            String linia = linia_pobrana.toLowerCase();
            Matcher matcher = pattern.matcher(linia);
            System.out.print(" " + linia + " ");
            if (isNice(linia)) {
                count1++;
                System.out.print(" NICE1 ");
            }
            if (ABA(linia)) {
                System.out.println(" NICE2 ");
            }
            System.out.println("\n");
            while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.println("Group " + i + ": " + matcher.group(i));
                }
                if (ABA(linia)) {
                    count2++;
                }

            }

        }

        System.out.println(count1);
        System.out.println(count2);


    }
}
