import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        final String[] splitSentence = sentence.split(" ");

        String max = "";

        for (String s : splitSentence) {
            if (s.length() > max.length()) {
                max = s;
            }
        }

        System.out.println(max);
    }
}