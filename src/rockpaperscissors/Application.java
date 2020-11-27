package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final int ROCK = 2;
    private static final int PAPER = 3;
    private static final int SCISSORS = 1;
    private static final int RESTART_GAME = 2;
    private static final int END_GAME = 1;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
	    while (true) {
	        System.out.println("------------- 게임 시작 --------------");
	        startGame();
            System.out.println("-------------- 게임 끝 ---------------");

            System.out.println("게임을 종료는 1, 재식작은 2를 입력해주세요.");
            int playerInput = getUserInput(1, 1, 2);

            if (playerInput == RESTART_GAME) {
                continue;
            }

            if (playerInput == END_GAME) {
                break;
            }
        }
    }

    public static int getUserInput(int requiredlength, int startInclusive, int endInclusive) {
        String playerInput;

        while (true) {
            System.out.print("입력: ");
            playerInput = SCANNER.nextLine();

            if (!checkLength(playerInput, requiredlength)) {
                System.out.println(requiredlength + "자리를 입력해주세요");
                continue;
            }

            if (!checkNumberRange(playerInput, startInclusive, endInclusive)) {
                System.out.println(startInclusive + "과 " + endInclusive + "사이의 숫자를 입력해주세요.");
                continue;
            }

            break;
        }

        return Integer.parseInt(playerInput);
    }

    public static boolean checkNumberRange(String playerInput, int startInclusive, int endInclusive) {
        int playerNumber;

        try {
            playerNumber = Integer.parseInt(playerInput);
        } catch (Exception exception) {
            System.out.println("다른 문자가 아닌 숫자를 입력해주세요.");
            return false;
        }

        return startInclusive <= playerNumber && playerNumber <= endInclusive;
    }

    public static boolean checkLength(String playerInput, int requiredlength) {
        return playerInput.length() == requiredlength;
    }

    public static void startGame() {
        System.out.println("가위는 1, 바위는 2, 보는 3을 입력해주세요.");
        System.out.print("입력: ");
        int playerInput = getUserInput(1, 1, 3);
        int aiInput = RANDOM.nextInt(3) + 1;

        String summary = getSummary(playerInput, aiInput);
        System.out.println(summary);

        String result = getResult(playerInput, aiInput);
        System.out.println(result);
    }

    public static String getResult(int playerInput, int aiInput) {
        String result = "";

        // ROCK
        if (playerInput == ROCK && aiInput == ROCK) {
            result = "무승부";
        }

        if (playerInput == ROCK && aiInput == PAPER) {
            result = "패배";
        }

        if (playerInput == ROCK && aiInput == SCISSORS) {
            result = "승리";
        }

        // PAPER
        if (playerInput == PAPER && aiInput == ROCK) {
            result = "승리";
        }

        if (playerInput == PAPER && aiInput == PAPER) {
            result = "무승부";
        }

        if (playerInput == PAPER && aiInput == SCISSORS) {
            result = "패배";
        }

        // SCISSORS
        if (playerInput == SCISSORS && aiInput == ROCK) {
            result = "패배";
        }

        if (playerInput == SCISSORS && aiInput == PAPER) {
            result = "승리";
        }

        if (playerInput == SCISSORS && aiInput == SCISSORS) {
            result = "무승부";
        }

        return "결과는 " + result + "입니다.";
    }

    public static String getSummary(int playerInput, int aiInput) {
        String playerChoice = getChoice(playerInput);
        String aiChoice = getChoice(aiInput);

        return "당신은 " + playerChoice + "를 냈고, AI는 " + aiChoice + "를 냈습니다.";
    }

    public static String getChoice(int input) {
        String choice = "";

        if (input == ROCK) {
            choice = "바위";
        }

        if (input == PAPER) {
            choice = "보";
        }

        if (input == SCISSORS) {
            choice = "가위";
        }

        return choice;
    }
}
