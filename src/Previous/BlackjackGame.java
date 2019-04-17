package Previous;

import java.util.*;

// Sara Staszak

/* Blackjack Game homework:
 * due 2/4 11:54pm add to discussion
 * due 2/5 11:54pm upload assignment (must compile)
 *
 * while playAgain != 'n'
 * print two numbers (first cards), -> can we just initialize hand to have the first two random numbers?
 *              bc we haven't learned arrays ok, got it.
 * print total of all dealt cards in hand, -> sum hand
 * print would you like to play again,
 * update playAgain
 *
 * logic set up if sum < 21 ask play again
 * if sum = 21 you win!
 * if sum > 21 bust
 *
 *
 * */
public class BlackjackGame {
    public static void main(String args[]){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        char playAgain = 'y';
        int gamecount = 1;
        int wins = 0;

        while(playAgain != 'n') {
            int firstCard = random.nextInt((10-1)+1)+1; //need to limit so no 0s
            int secondCard = random.nextInt((10-1)+1)+1;
            int hand = firstCard + secondCard;

            char deal = 'y';
            System.out.println("First cards: " + firstCard + ", " + secondCard);
            System.out.println("Total: " + hand);
            while(deal != 'n') {
                System.out.print("Do you want another card? (y/n):");
                deal = input.next().charAt(0);
                //add a break here explicitly for n, reset deal to y
                if(deal == 'n') {
                    break;
                }

                int newCard = random.nextInt((10-1)+1)+1;
                hand = hand + newCard;

                System.out.println("Card: " + newCard);
                System.out.println("Total: " + hand);
                if(hand == 21){
                    System.out.println("Blackjack!");
                    wins = wins + 1;
                    break;
                }
                else if(hand >21){
                    System.out.println("Bust.");
                    break;
                }


            }


            System.out.print("You've played "+ gamecount + " games. (and won "+wins + ") " +"Would you like to play again? (y/n): ");
            playAgain = input.next().charAt(0);
            gamecount = gamecount + 1;
        }
    }

}
