import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println(encode(scanner.next()));
    }

    public static String encode(String sequence) {
        String encodedSequence = "";
        int count = 1;

        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);

            if (i + 1 < sequence.length() && sequence.charAt(i) == sequence.charAt(i + 1)) {
                count++;
            } else {
                encodedSequence += String.valueOf(letter) + count;
                count = 1;
            }
        }

        return encodedSequence;
    }
}