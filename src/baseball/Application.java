package baseball;

import java.util.Scanner;

public class Application {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            Game.start();

            if (endApplication()) {
                break;
            }
        }
    }

    public static boolean endApplication() {
        String userInput = SCANNER.nextLine();

        if (userInput.equals("end")) {
            return true;
        }

        return false;
    }
}
