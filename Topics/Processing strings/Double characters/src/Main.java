import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        String soubledCharacters = "";

        for (int i = 0; i < word.length(); i++) {
            soubledCharacters += word.charAt(i) + "" + word.charAt(i);
        }

        System.out.println(soubledCharacters);
    }
}