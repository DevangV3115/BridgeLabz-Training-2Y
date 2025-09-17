import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (!feedback.equalsIgnoreCase("correct")) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: high/low/correct)");
            feedback = sc.nextLine();

            if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
        }

        System.out.println("Yay! I guessed your number.");
    }
}
