import java.util.*;

public class BlackjackStats {
    public static void main(String args[]){
        Random random = new Random();
        //Scanner input = new Scanner(System.in);
        //char playAgain = 'y';

            int gamecount = 1;
            int wins = 0;

            while(gamecount < 1000) {
                int firstCard = random.nextInt((10-1)+1)+1; //need to limit so no 0s
                int secondCard = random.nextInt((10-1)+1)+1;
                int hand = firstCard + secondCard;

            //char deal = 'y';
            //System.out.println("First cards: " + firstCard + ", " + secondCard);
            //System.out.println("Total: " + hand);
                while(hand < 21) {
                //System.out.print("Do you want another card? (y/n):");
                //deal = input.next().charAt(0);
                //add a break here explicitly for n, reset deal to y

                    int newCard = random.nextInt((10-1)+1)+1;
                    hand = hand + newCard;

                //System.out.println("Card: " + newCard);
                //System.out.println("Total: " + hand);
                }
                if(hand == 21){
                //System.out.println("Blackjack!");
                    wins = wins + 1;
                //break;
                }
            //System.out.print("You've played "+ gamecount + " games. (and won "+wins + ") " +"Would you like to play again? (y/n): ");
            //playAgain = input.next().charAt(0);
                gamecount = gamecount + 1;
            }
            double pct = wins/(gamecount*1.0);
            System.out.println("In " + gamecount + " games, you have won " + wins + " times for a win % of " + pct);
    }
}
