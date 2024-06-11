import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int c = sc.nextInt();
        final int n = sc.nextInt();

        System.out.println(generarePassword(a, b, c, n - (a + b + c)));
    }

    private static String generarePassword(int a, int b, int c, int n) {
        String password = "";

        password += getAllByType(a, 'A');
        password += getAllByType(b, 'B');
        password += getAllByType(c, 'C');
        password += getAllByType(n, 'N');

        return password;
    }

    private static String getAllByType(int size, char typeGet) {
        String fragmentsPassword = "";

        for (int i = 0; i < size; i++) {
            final char value = getValue(typeGet);

            if (i == 0) {
                fragmentsPassword += value;
            } else if (fragmentsPassword.charAt(i - 1) != value) {
                fragmentsPassword += value;
            } else {
                fragmentsPassword += preventNotRepeat(fragmentsPassword.charAt(i - 1), typeGet);
            }
        }

        return fragmentsPassword;
    }

    private static char preventNotRepeat(char valueNoRepeatable, char typeGet) {
        char value = getValue(typeGet);

        while (value == valueNoRepeatable) {
            value = getValue(typeGet);
        }

        return value;
    }

    private static char getValue(char typeGet) {
        return switch (typeGet) {
            case 'A' -> getA();
            case 'B' -> getB();
            case 'C' -> getC();
            case 'N' -> getValue(getN());
            default -> 0;
        };
    }

    private static int getRandomValue(int minRange, int maxRange) {
        return new Random().nextInt((maxRange - minRange) + 1) + minRange;
    }

    private static char getA() {
        return (char) (getRandomValue(65, 90));
    }

    private static char getB() {
        return (char) (getRandomValue(97, 122));
    }

    private static char getC() {
        return (char) (getRandomValue(49, 57));
    }

    private static char getN() {
        return (char) (getRandomValue(65, 67));
    }
}