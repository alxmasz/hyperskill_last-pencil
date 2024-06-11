import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // The first operation goes here
        System.out.println(input % 2);
        // The second operation goes here
        System.out.println((input % 2) * 3);

        scanner.close();
    }
}
