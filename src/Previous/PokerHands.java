package Previous;

import java.util.*;


public class PokerHands {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        char keepPlaying = 'y';
        while(keepPlaying=='y') {
            //playOneHand();
            playManyHands(100);

            System.out.print("Do you want to play again? (y/n)");
            keepPlaying = input.next().charAt(0);
        }
    }

    public static void playManyHands(int nhand){

        int quads = 0;
        int house = 0;
        int trips = 0;
        int pair2 = 0;
        int pair = 0;
        int straight = 0;
        int high = 0;
        for(int i=0; i<nhand; i++){
            int[]  hand = randomHand();

            if(containsFourOfaKind(hand)){
                quads ++;
            }
            else if(containsFullHouse(hand)){
                house ++;
            }
            else if(containsThreeOfaKind(hand)) {
                trips ++;
            }
            else if(containsTwoPair(hand)) {
                pair2 ++;
            }
            else if(containsPair(hand)) {
                pair ++;
            }
            else if(containsStraight(hand)) {
                straight ++;
            }
            else {
                high ++;
            }
        }
        System.out.println("In " + nhand + " tries there were: " + high + " high cards, " + pair + " single pairs, "
                + pair2 + " two pairs, " + trips + " three of a kinds, " + quads + " four of a kinds, " + house + " full houses, and " + straight + " straights");
    }

    public static void playOneHand(){
        //int[]  hand = generateHand();
        int[] hand = getHand();

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
    }

    public static int handCounts(int hand[], int typen){
        int typecount = 0;
        for(int i=0; i<hand.length; i++){
            int ccount = cardCount(hand, hand[i]);
            if(ccount == typen){
                typecount ++;
                //this is counting for each, so a pair gets counted twice, four of a kind gets counted 4 times
            }

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

        return (containsPair(hand) & containsThreeOfaKind(hand));
    }

    public static boolean containsFourOfaKind(int hand[]){
        //checks if hand contains 4 of a kind
        int quad = handCounts(hand, 4);

        return (quad==4);
    }

    public static boolean containsStraight(int hand[]){
        //checks if hand contains a straight
        //sort array first...
        boolean possibleStraight = true;
        Arrays.sort(hand);
        for(int i=0; i<hand.length-1; i++){
            if(hand[i]+1!=hand[i+1]){
                possibleStraight = false;
            }
        }
        return possibleStraight;
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
                System.out.println("Please only use 2-9: ");
                //need to get input again
                hand[i] = input.nextInt();
            }
        }
        return hand;
    }

    public static int[] generateHand(char htype){
        //depending on user input for hand type (htype) generate or get hand
        //not quite pretty yet.
        //instead of asking for hand, generate it
        int hand[] = new int[5];
        if(htype == 'r') {
            for (int i = 0; i < hand.length; i++) {
                hand[i] = randCardValue();
            }
            System.out.println("Your hand consists of: " + hand[0] + ", " + hand[1] + ", " + hand[2] + ", " + hand[3] + ", " + hand[4]);
        }
        else if(htype== 'o') {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter five numeric cards, no face cards. Use 2-9.");
            for(int i=0; i<hand.length; i++){
                System.out.print("Card " + (i+1) + ":");
                int card = input.nextInt();
                if(card==2 | card==3 | card==4 | card==5 | card==6 | card==7 | card==8 | card==9){
                    hand[i] = card;
                }
                else {
                    System.out.println("Please only use 2-9: ");
                    //need to get input again
                    hand[i] = input.nextInt();
                }
            }
        }
        return hand;
    }
    public static int[] randomHand(){
        int hand[] = new int[5];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = randCardValue();
        }
        return hand;
    }
    public static int randCardValue(){
        Random rand = new Random();
        return rand.nextInt(8) + 2;
    }

}
