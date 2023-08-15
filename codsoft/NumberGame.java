import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        int random = (int) (Math.random() * 100) + 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("Guess a number between 1 and 100.");
        int guess = sc.nextInt();
        int chance = 10;

        while (guess != random) {
            chance--;
            if (chance == 0)
                break;
            if (guess < random) {
                System.out.println("Too Low.Try Again");
            } else {
                System.out.println("Too High.Try Again");
            }

            System.out.println("Guess again.(" + chance + " attempts left)");
            guess = sc.nextInt();
        }

        if (guess == random) {
            System.out.println("You guessed the correct number! Your score is " + (chance));
        } else {
            System.out.println("Opps! No more chances left.");
        }
        System.out.println("Would you like to play again?(Press 'Y' for YES and 'N' for NO))");
        String answer = sc.next();

        if (answer.equals("Y")) {
            main(args);
        } else {
            System.exit(0);
        }
        sc.close();
    }
}
