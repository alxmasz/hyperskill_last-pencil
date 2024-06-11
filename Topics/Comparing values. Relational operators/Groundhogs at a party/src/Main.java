import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value
        int peanutButterCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        System.out.println(
                (!isWeekend && peanutButterCups >= 10 && peanutButterCups <= 20) ||
                        (isWeekend && peanutButterCups >= 15 && peanutButterCups <= 25)
        );
    }
}