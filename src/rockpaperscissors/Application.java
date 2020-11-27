package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final int SCISSORS = 1;
    private static final int ROCK = 2;
    private static final int PAPER = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
	    while (true) {
	        System.out.println("------------- 게임 시작 --------------");
	        startGame();
        }
    }

    public static void startGame() {
        System.out.println("가위는 1, 바위는 2, 보는 3을 입력해주세요.");
        int playerNumber = Integer.parseInt(SCANNER.nextLine());
        int aiNumber = RANDOM.nextInt(3) + 1;

        // 사용자
        if (playerNumber == ROCK) {
            System.out.println("당신은 바위를 냈습니다.");
        }

        if (playerNumber == PAPER) {
            System.out.println("당신은 보를 냈습니다.");
        }

        if (playerNumber == SCISSORS) {
            System.out.println("당신는 가위를 냈습니다.");
        }

        // 컴퓨터
        if (aiNumber == ROCK) {
            System.out.println("AI는 바위를 냈습니다.");
        }

        if (aiNumber == PAPER) {
            System.out.println("AI는 보를 냈습니다.");
        }

        if (aiNumber == SCISSORS) {
            System.out.println("AI는 가위를 냈습니다.");
        }

        // ROCK
        if (playerNumber == ROCK && aiNumber == ROCK) {
            System.out.println("무승부");
        }

        if (playerNumber == ROCK && aiNumber == PAPER) {
            System.out.println("패배");
        }

        if (playerNumber == ROCK && aiNumber == SCISSORS) {
            System.out.println("승리");
        }

        // PAPER
        if (playerNumber == PAPER && aiNumber == ROCK) {
            System.out.println("승리");
        }

        if (playerNumber == PAPER && aiNumber == PAPER) {
            System.out.println("무승부");
        }

        if (playerNumber == PAPER && aiNumber == SCISSORS) {
            System.out.println("패배");
        }

        // SCISSORS
        if (playerNumber == SCISSORS && aiNumber == ROCK) {
            System.out.println("패배");
        }

        if (playerNumber == SCISSORS && aiNumber == PAPER) {
            System.out.println("승리");
        }

        if (playerNumber == SCISSORS && aiNumber == SCISSORS) {
            System.out.println("무승부");
        }
    }
}
