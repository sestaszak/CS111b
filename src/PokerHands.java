import java.util.*;


public class PokerHands {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        char keepPlaying = 'y';
        while(keepPlaying=='y') {
            int hand[] = getHand();

            if(containsFourOfaKind(hand)){
                System.out.println("Four of a kind!");
            }
            else if(containsFullHouse(hand)){
                System.out.println("Full house!");
            }
            else if(containsThreeOfaKind(hand)) {
                System.out.println("Three of a kind!");
            }
            else if(containsTwoPair(hand)) {
                System.out.println("Two Pair!");
            }
            else if(containsPair(hand)) {
                System.out.println("Pair!");
            }
            else if(containsStraight(hand)) {
                System.out.println("Straight!");
            }
            else {
                System.out.println("High Card!");
            }

//            System.out.println("Checking for one pair: " + containsPair(hand));
//            System.out.println("Checking for two pairs: " + containsTwoPair(hand));
//            //System.out.println("Count of pairs: " + handCounts(hand, 2));
//            System.out.println("Checking for three of a kind: " + containsThreeOfaKind(hand));
//            System.out.println("Checking for full house: " + containsFullHouse(hand));
//            System.out.println("Checking for four of a kind: " + containsFourOfaKind(hand));
            System.out.println("Do you want to play again? (y/n)");
            keepPlaying = input.next().charAt(0);
        }
    }

    public static int handCounts(int hand[], int typen){
        int typecount = 0;
        for(int i=0; i<hand.length; i++){
            int ccount = cardCount(hand, hand[i]);
            if(ccount == typen){
                typecount ++;
            }
           // System.out.println("iter: " + i + "card count: " + ccount + " type count: " + typecount + " and type: " + typen);
        }
        return typecount;
    }

    public static int cardCount(int hand[], int card){
        //helper method counts number of occurances of a card in the hand
        int count = 0;
        for(int i=0; i<hand.length; i++){
            if(hand[i]==card){
                count ++;
            }
        }
        return count;
    }

    public static boolean containsPair(int hand[]){
        //checks if hand contains a pair
        int pairs = handCounts(hand, 2);
        return  (pairs >= 1);
    }

    public static boolean containsTwoPair(int hand[]){
        //checks if hand contains two pairs
        int pairs = handCounts(hand, 2);
        return (pairs ==4);
   }
//
    public static boolean containsThreeOfaKind(int hand[]){
        //checks if hand contains 3 of a kind
        int trips = handCounts(hand, 3);
        return (trips == 3);
    }

    public static boolean containsFullHouse(int hand[]){
        //checks if hand contains a full house (pair + 3 of kind)
        int pair = handCounts(hand, 2);
        int trip = handCounts(hand, 3);

        //could also call containsThreeOfaKind and containsPair

        return (pair==1 & trip==1);
    }

    public static boolean containsFourOfaKind(int hand[]){
        //checks if hand contains 4 of a kind
        int quad = handCounts(hand, 4);

        return (quad==4);
    }

    public static boolean containsStraight(int hand[]){
        //checks if hand contains a straight
        //sort array first...


    }

    public static int[] getHand(){
        int hand[] = new int[5] ;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five numeric cards, no face cards. Use 2-9.");
        for(int i=0; i<hand.length; i++){
            System.out.print("Card " + (i+1) + ":");
            int card = input.nextInt();
            if(card==2 | card==3 | card==4 | card==5 | card==6 | card==7 | card==8 | card==9){
                hand[i] = card;
            }
            else {
                System.out.println("Please only use 2-9. ");
                //need to get input again
            }
        }
        return hand;
    }
}
