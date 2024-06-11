import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(countHarshSounding(sc.next()));
    }

    private static int countHarshSounding(String word) {
        int countConsonant = 0, countVowel = 0, countConverts = 0;
        final char[] letters = word.toLowerCase().toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            if (isVowel(letters[i])) {
                countVowel++;
                countConsonant = 0;
            } else {
                countConsonant++;
                countVowel = 0;
            }

            boolean existHarshSounding = (countVowel == 2 && isVowel(letters[i + 1])) || (countConsonant == 2 && !isVowel(letters[i + 1]));

            if (existHarshSounding) {
                countConverts++;
                countVowel = 0;
                countConsonant = 0;
            }
        }

        return countConverts;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
}