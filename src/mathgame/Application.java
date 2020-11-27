package mathgame;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static int userScore = 0;
    private static final String CORRECT = "correct";
    private static final String WRONG = "wrong";
    private static final String ADD = "1";
    private static final String SUBTRACT = "2";
    private static final String MULTIPLY = "3";
    private static final String DIVIDE = "4";
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String gameResult = simulateGame();

            if (gameResult.equals(CORRECT)) {
                userScore++;
            }

            if (gameResult.equals(WRONG)) {
                userScore--;
            }

            System.out.println("score: " + userScore);
        }
    }

    public static String simulateGame() {
        String question = makeQuestion();
        System.out.println(question + " = ?");

        int userGuess = getInput();
        int answer = solveAnswer(question);
        String result = getResult(userGuess, answer);

        return result;
    }

    public static String getResult(int answer, int userGuess) {
        String result = "";

        if (answer == userGuess) {
            result = CORRECT;
        }

        if (answer != userGuess) {
            result = WRONG;
        }
        return result;
    }

    public static int getInput() {
        int userInput = 0;

        while (true) {
            try {
                System.out.print("Your answer: ");
                userInput = Integer.parseInt(SCANNER.nextLine());
            } catch (Exception exception) {
                System.out.println("정수를 입력해주세요.");
                continue;
            }

            break;
        }
        return userInput;
    }

    public static int solveAnswer(String question) {
        String[] partition = question.split(" ");
        int answer = 0;

        if (partition[1].equals("+")) {
            answer = Integer.parseInt(partition[0]) + Integer.parseInt(partition[2]);
        }

        if (partition[1].equals("-")) {
            answer = Integer.parseInt(partition[0]) - Integer.parseInt(partition[2]);
        }

        if (partition[1].equals("*")) {
            answer = Integer.parseInt(partition[0]) * Integer.parseInt(partition[2]);
        }

        if (partition[1].equals("/")) {
            answer = Integer.parseInt(partition[0]) / Integer.parseInt(partition[2]);
        }

        return answer;
    }

    public static String makeQuestion() {
        String numberA = generateNumber(1, 10);
        String numberB = generateNumber(1, 10);
        String operator = generateOperator();

        if (operator.equals(" / ")) {
            numberA = String.valueOf(Integer.parseInt(numberA) * Integer.parseInt(numberB));
        }

        return numberA + operator + numberB;
    }

    public static String generateOperator() {
        String number = generateNumber(1, 4);
        String operator = "";

        if (number.equals(ADD)) {
            operator = " + ";
        }

        if (number.equals(SUBTRACT)) {
            operator = " - ";
        }

        if (number.equals(MULTIPLY)) {
            operator = " * ";
        }

        if (number.equals(DIVIDE)) {
            operator = " / ";
        }

        return operator;
    }

    public static String generateNumber(int startInclusive, int endInclusive) {
        return String.valueOf(startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1));
    }
}
