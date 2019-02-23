import java.util.*;

public class HighScores {

    public static void main(String args[]){
        // declare and initialize two array lists
        // invoke initialize, sort, and display methods
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();

        initialize(names, scores);
        sort(names, scores);
        display(names, scores);

    }

    public static void initialize(ArrayList<String> names, ArrayList<Integer> scores){
        //user input
        Scanner input = new Scanner(System.in);
        for(int index = 0; index<5; index++){
            System.out.print("Enter the name for score #" + (index+1) + ":");
            String name = input.next();
            names.add(name);
            System.out.print("Enter the score for score #" + (index+1) + ":");
            int score = input.nextInt();
            scores.add(score);
        }

    }

    public static void sort(ArrayList<String> names, ArrayList<Integer> scores){
        //sort scores list and update order of names to match
        int checkLoc, index, maxVal, maxIndex;
        String maxName, clName;

        for(checkLoc=0; checkLoc < names.size()-1; checkLoc++){
            maxIndex = checkLoc;
            maxVal = scores.get(checkLoc);
            maxName = names.get(checkLoc);
            clName = names.get(checkLoc);
            //System.out.println("Outer loop iter " + checkLoc + " with values: maxIndex=" + maxIndex + " and maxVal="+maxVal);

            for(index = checkLoc+1; index< names.size(); index++){
                //System.out.println("Inner loop iter " + index + ". Checking " + scores.get(index) + " greater than " + maxVal);
                if(scores.get(index)>maxVal){
                    maxVal = scores.get(index);
                    maxIndex = index;
                    maxName = names.get(index);
                    //System.out.println("Updated maxVal to " + maxVal + " and maxIndex to " + maxIndex);
                }
            }
            scores.set(maxIndex, scores.get(checkLoc));
            names.set(maxIndex, clName);
            scores.set(checkLoc, maxVal);
            names.set(checkLoc, maxName);
            //System.out.println("Updated value at maxIndex to " + scores.get(maxIndex) + " and value at checkLoc to " + scores.get(checkLoc));
        }
    }

    public static void display(ArrayList<String> names, ArrayList<Integer> scores){
        //display contents of both arraylists
        System.out.println("Top Scorers:");
        for(int index = 0; index<5; index++){
            System.out.println(names.get(index) + ": " + scores.get(index));
        }

    }
}
