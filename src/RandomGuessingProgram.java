import java.util.*;


public class RandomGuessingProgram {
    //call and test the (new) NumberGuesser class.
    public static void main(String args[]){
        RandomNumberGuesser rng = new RandomNumberGuesser(1, 10);
        System.out.println(rng.getCurrentGuess());
        System.out.println(rng.getCurrentGuess());
        System.out.println(rng.getCurrentGuess());

        playManualGame(1,10);
        playManualGame(1, 100);

        playRepsGame(10, 1, 100);

    }

    public static void playManualGame(int startLow, int startHigh){

        RandomNumberGuesser guesser = new RandomNumberGuesser(startLow, startHigh);
        int guess = guesser.getCurrentGuess();
        //System.out.println("Starting guess: " + guess);

        boolean matched = false;
        System.out.println("Guess a number between " + startLow + " and " + startHigh + ".");

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

    public static void playRepsGame(int reps, int startLow, int startHigh){
        Random random = new Random();
        RandomNumberGuesser guesser = new RandomNumberGuesser(startLow, startHigh);
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
