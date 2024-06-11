import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();

        // Your code comes here!
        System.out.println((minutes / 60)  + " hours and " + (minutes % 60) + " minutes" );

        scanner.close();
    }
}