import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        long sum = 0;
        Random r = new Random(a + b);
        for (int i = 0; i < n; i++) {
            sum += r.nextInt(b - a + 1) + a;
        }

        System.out.println(sum);
    }
}