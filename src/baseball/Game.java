package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final Random RANDOM = new Random();

    public static void start() {
        List<Integer> computerNumber = new ArrayList<>();

        while (true) {
            int randomNumber = RANDOM.nextInt(9) + 1;

            if (computerNumber.contains(randomNumber)) {
                System.out.println(computerNumber + " " + randomNumber);
                continue;
            }

            computerNumber.add(randomNumber);

            if (computerNumber.size() == 3) {
                break;
            }
        }

        System.out.println(computerNumber);
    }
}