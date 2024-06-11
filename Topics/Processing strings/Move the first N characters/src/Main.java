import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int moves = scanner.nextInt();

        if (moves > word.length()) {
            System.out.println(word);
            return;
        }

        System.out.println(word.substring(moves) + word.substring(0, moves));
    }
}