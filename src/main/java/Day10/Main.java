package Day10;

public class Main {
    private static String lookAndSay(String number) {
        StringBuilder result = new StringBuilder();

        char repeat = number.charAt(0);
        number = number.substring(1) + " ";
        int times = 1;

        for (char actual : number.toCharArray()) {
            if (actual != repeat) {
                result.append(times).append(repeat);
                times = 1;
                repeat = actual;
            } else {
                times += 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String number = "3113322113";
        for (int i = 0; i < 50; i++) {
            System.out.println(number);
            number = lookAndSay(number);
            System.out.println(number.length());
        }
    }
}
