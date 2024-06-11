import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();

        boolean found = false;

        while (!found) {
            Random random = new Random(k);
            found = true;

            for (int i = 0; i < n; i++) {
                double gaussian = random.nextGaussian();
                if (gaussian >= m) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println(k);
            }

            k++;
        }

    }
}