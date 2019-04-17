package Previous;

import java.util.*;

public class NumberGuesserPlus{

    public static void main(String[] args){
        do {
            playOneGame();
        } while (shouldPlayAgain());
    }

    public static void playOneGame() {
        int guess = 50;
        int high = 100;
        int low = 1;
        boolean matched = false;
        System.out.println("Guess a number between 1 and 100.");

        while(!matched) {
            //System.out.println("Now guessing between " + low + " and " + high);
            char perf = getUserResponseToGuess(guess);

            if(perf=='h'){
                low = guess+1;
            }
            else if(perf=='l'){
                high = guess-1;
            }
            else if (perf=='c'){
                matched = true;
            }

            guess = getMidpoint(low, high);
        }


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

    public static int getMidpoint(int low, int high) {
        // return midpoint of two ints, if two values in middle
        // consistently return smaller of two (like if midpoint is 50.5?)
        // midpoint formula = (x1 + x2)/2
        int midpt = (high + low)/2; //maybe take floor of this, if floor function
        // integer division by default returns an integer without rounding (so floor).
        return(midpt);
    }
}