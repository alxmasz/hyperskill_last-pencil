import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int units = scanner.nextInt();
        System.out.println(units > -15 && units <= 12 || units > 14 && units < 17 || units >= 19 ? "True" : "False");
    }
}