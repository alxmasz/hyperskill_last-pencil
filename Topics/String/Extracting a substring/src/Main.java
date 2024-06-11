import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        final String text = scanner.nextLine();
        final int init = scanner.nextInt();
        final int end = scanner.nextInt();

        System.out.println(text.substring(init, end + 1));
    }
}