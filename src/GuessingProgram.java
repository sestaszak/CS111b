import java.util.*;

public class GuessingProgram {

    //call and test the (new) NumberGuesser class.
    public static void main(String args[]){
        System.out.println("Play a manual game with user entry");
        playManualGame(1, 100);
        System.out.println("Play manual games until player quits");
        playManyManualGames();
        System.out.println("Played many games to get average number of guesses");
        playRepsGame(1000, 1, 100);
        playRepsGame(1000, 1, 500);
        System.out.println("Played the example game in assignment");
        playTestGame();
    }

    public static void playTestGame(){
        NumberGuesser guesser = new NumberGuesser(1, 100);
        // test target = 72
        System.out.println(guesser.getCurrentGuess()); //50
        guesser.higher();
        System.out.println(guesser.getCurrentGuess()); //75
        guesser.lower();
        System.out.println(guesser.getCurrentGuess()); //62
        guesser.higher();
        System.out.println(guesser.getCurrentGuess()); //68
        guesser.higher();
        System.out.println(guesser.getCurrentGuess()); //71
        guesser.higher();
        System.out.println(guesser.getCurrentGuess()); //73
        guesser.lower();
        System.out.println(guesser.getCurrentGuess()); //72

        //this matches correctly
    }

    public static void playManualGame(int startLow, int startHigh){

        NumberGuesser guesser = new NumberGuesser(startLow, startHigh);
        int guess = guesser.getCurrentGuess();
        //System.out.println("Starting guess: " + guess);

        boolean matched = false;
        System.out.println("Guess a number between 1 and 100.");

        while(!matched) {
            //System.out.println("Now guessing between " + low + " and " + high);
            char perf = getUserResponseToGuess(guess);

            if(perf=='h'){
                guesser.higher();
                //System.out.println("Call to higher method since response was h");
            }
            else if(perf=='l'){
                guesser.lower();
                //System.out.println("Call to lower method since response was l");
            }
            else if (perf=='c'){
                matched = true;
            }

            guess = guesser.getCurrentGuess();
            if(guess < startLow | guess > startHigh) {
                System.out.println("User response results in a guess out of the range. Did you answer truthfully? Exiting game.");
                matched = true;
            }
            //System.out.println("Updated guess: " + guess);
        }

        guesser.reset();

    }

    public static char getUserResponseToGuess(int guess) {
        // prompt user by asking: "is it <guess>? (h/l/c):"
        // return char (h/l/c)
        Scanner input = new Scanner(System.in);

        System.out.print("is it " + guess + "? (h/l/c):");
        char response = input.next().charAt(0);

        //check that response is only h/l/c and return
        //else ?? ask again?
        if((response == 'h') || (response == 'l') || (response == 'c')) {
            return response;
        }
        else {
            System.out.println("Hmm, that's not quite right. Please only respond with h, l, or c.");
        }
        return response;
    }

    public static boolean shouldPlayAgain() {
        //ask if play again, read character, return boolean based on character
        Scanner input = new Scanner(System.in);
        // can i just have one scanner in main?
        System.out.print("Great! Do you want to play again? (y/n):");
        char response = input.next().charAt(0);
        boolean playAgain = (response == 'y');
        return playAgain;
    }

    public static void playManyManualGames(){
        do {
            playManualGame(1, 100);
        } while (shouldPlayAgain());
    }

    public static void playRepsGame(int reps, int startLow, int startHigh){
        Random random = new Random();
        NumberGuesser guesser = new NumberGuesser(startLow, startHigh);
        int totalGuessCount = 0;

        for (int i = 0; i < reps; i++) {
            // There is always the initial guess
            int guessCount = 1;

            // Generate a random value to look for, from MIN to MAX, inclusive.
            int targetValue = startLow + random.nextInt(startHigh - startLow + 1);
            //System.out.println("Random target value is: " + targetValue);

            // Keep looping until the guesser gets it right
            while (targetValue != guesser.getCurrentGuess()) {
                // Adjust the guesser, as needed...
                //System.out.println("Current guess is: " + guesser.getCurrentGuess());
                if (targetValue > guesser.getCurrentGuess()) {
                    guesser.higher();
                } else {
                    guesser.lower();
                }

                // That's one more guess, bump up the count
                guessCount++;
            }

            // Keep track of the total number of guesses in all the simulated games
            totalGuessCount += guessCount;

            // Return the guesser is in its initial state
            guesser.reset();
        }
        // Calculate and display the average
        double averageGuessCount = totalGuessCount / (double) reps;
        System.out.println("Average number of guesses: " + averageGuessCount + " in " + reps + " games, guessing between " + startLow + " and " + startHigh);

    }

}
