import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int seedMinimum = 0;
        int minValueSequencesMax = k;

        for (int i = a; i <= b; i++) {
            final Random random = new Random(i);

            int maxValueSequenceSeed = 0;
            for (int j = 0; j < n; j++) {
                final int randomValue = random.nextInt(k);
                if (randomValue > maxValueSequenceSeed) {
                    maxValueSequenceSeed = randomValue;
                }
            }

            if (maxValueSequenceSeed < minValueSequencesMax) {
                seedMinimum = i;
                minValueSequencesMax = maxValueSequenceSeed;
            }
        }

        System.out.println(seedMinimum);
        System.out.println(minValueSequencesMax);
    }
}