import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int num = scanner.nextInt();
        System.out.println((num / 10) % 10);
        scanner.close();
    }
}