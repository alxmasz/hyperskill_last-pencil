package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pencils = getInitPencils();

        final Player player1 = getPlayerTypeByName(getInitPlayer());
        final Player player2 = getPlayerTypeByName(getNextPlayer(player1.getName()));

        playGame(pencils, player1, player2);
    }

    private static void playGame(int pencils, Player... players) {
        int turns = 0;
        Player playerTurn;

        do {
            printPencils(pencils);

            playerTurn = players[turns % players.length];

            int pencilsTaken = getPencilsPlayerTurn(playerTurn, pencils);

            pencils -= pencilsTaken;

            turns++;
        } while (pencils > 0);

        verifyPlayerWon(players[turns % players.length], pencils);
    }

    private static int getInitPencils() {
        Scanner scanner = new Scanner(System.in);
        String pencils;

        System.out.println("How many pencils would you like to use:");

        do {
            pencils = scanner.nextLine();
        } while (!isValidPencils(pencils));

        return Integer.parseInt(pencils);
    }

    private static String getInitPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Who will be the first (John, Jack):");
        String name = scanner.nextLine();

        while (!name.equals("John") && !name.equals("Jack")) {
            System.out.println("Choose between 'John' and 'Jack'");
            name = scanner.nextLine();
        }

        return name;
    }

    private static Player getPlayerTypeByName(String name) {
        if (name.equals("John")) {
            return new User("John");
        }

        return new Bot("Jack");
    }

    private static int getPencilsPlayerTurn(Player player, int pencilsInGame) {
        String pencils;

        System.out.printf("%s's turn%c%n", player.getName(), player.isBot() ? ':' : '!');

        do {
            pencils = player.getPencilsTurn(pencilsInGame);
        } while (!isValidPencilsTurn(pencils, pencilsInGame));

        if (player.isBot()) {
            System.out.println(pencils);
        }

        return Integer.parseInt(pencils);
    }

    private static String getNextPlayer(String actualPlayerTurn) {
        return actualPlayerTurn.equals("John") ? "Jack" : "John";
    }

    private static void verifyPlayerWon(Player player, int pencilsInGame) {
        if (pencilsInGame == 0) {
            System.out.println(player.getName() + " won!");
        }
    }

    private static boolean isValidPencils(String pencils) {
        if (!isNumeric(pencils)) {
            System.out.println("The number of pencils should be numeric.");
            return false;
        }

        if (Integer.parseInt(pencils) == 0) {
            System.out.println("The number of pencils should be positive.");
            return false;
        }

        return true;
    }

    private static boolean isValidPencilsTurn(String pencils, int pencilsInGame) {
        if (!isNumeric(pencils) || (Integer.parseInt(pencils) < 1 || Integer.parseInt(pencils) > 3)) {
            System.out.println("Possible values: '1', '2' or '3'");
            return false;
        }

        if (Integer.parseInt(pencils) > pencilsInGame) {
            System.out.println("Too many pencils were taken");
            return false;
        }

        return true;
    }

    private static void printPencils(int pencils) {
        System.out.println("|".repeat(pencils));
    }

    private static boolean isNumeric(String value) {
        return value != null && value.matches("\\d+$");
    }
}

abstract class Player {
    private final String name;

    public Player(final String name) {
        this.name = name;
    }

    public abstract boolean isBot();

    public abstract String getPencilsTurn(final int pencils);


    public String getName() {
        return name;
    }
}

class User extends Player {
    public User(final String name) {
        super(name);
    }

    @Override
    public boolean isBot() {
        return false;
    }

    @Override
    public String getPencilsTurn(final int pencils) {
        return new Scanner(System.in).nextLine();
    }
}

class Bot extends Player {
    public Bot(final String name) {
        super(name);
    }

    @Override
    public boolean isBot() {
        return true;
    }

    @Override
    public String getPencilsTurn(final int pencils) {
        return String.valueOf(getPencils(pencils));
    }

    private int getPencils(final int pencils) {
        if (pencils == 1) {
            return 1;
        }

        final int i = pencils % 4;

        return switch (i) {
            case 2 -> 1;
            case 3 -> 2;
            case 0 -> 3;
            default -> {
                final Random random = new Random();
                yield random.nextInt(3) + 1;
            }
        };
    }
}
