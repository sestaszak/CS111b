import java.util.*;

public class HighScoresProgram {

//    Create a separate file named HighScoresProgram.java. This file should contain a class that has only four following static methods.
//
//
    public static void main(String args[]){
        //    The main method should allocate an array of five HighScore references, and then invoke the other three methods.
        HighScore[] hsArray = new HighScore[5];
        initialize(hsArray);
        sort(hsArray);
        display(hsArray);
    }
//
    public static void initialize(HighScore[] scores){
        //user input
        Scanner input = new Scanner(System.in);
        for(int i=0; i<scores.length; i++){
            System.out.print("Enter the name for score #" + (i+1) + ":");
            String name = input.next();
            System.out.print("Enter the score for score #" + (i+1) + ":");
            int score = input.nextInt();
            HighScore addedScores = new HighScore(name, score);
            scores[i] = addedScores;
        }
    }
//
    public static void sort(HighScore[] scores){
        //sort scores list and update order of names to match
        int checkLoc, index, maxVal, maxIndex, clVal;
        String maxName, clName;
        //HighScore[] tempSorted = new HighScore[5];

        for(checkLoc=0; checkLoc < scores.length-1; checkLoc++){
            maxIndex = checkLoc;
            maxVal = scores[maxIndex].getScore();
            maxName = scores[maxIndex].getName();
            clName = scores[checkLoc].getName();
            clVal = scores[checkLoc].getScore();
//            System.out.println("Outer loop iter " + checkLoc + " with values: maxIndex=" + maxIndex + " and maxVal="+maxVal);

            for(index = checkLoc+1; index< scores.length; index++){
                //System.out.println("Inner loop iter " + index + ". Checking " + scores.get(index) + " greater than " + maxVal);
                if(scores[index].getScore()>maxVal){
                    maxVal = scores[index].getScore();
                    maxIndex = index;
                    maxName = scores[index].getName();
//                    System.out.println("Updated maxVal to " + maxVal + " and maxIndex to " + maxIndex);
                }
            }
            scores[maxIndex].setScore(clVal);
            scores[maxIndex].setName(clName);
            scores[checkLoc].setScore(maxVal);
            scores[checkLoc].setName(maxName);
//            //System.out.println("Updated value at maxIndex to " + scores.get(maxIndex) + " and value at checkLoc to " + scores.get(checkLoc));
        }

    }
//
    public static void display(HighScore[] scores){
        System.out.println("Top Scorers:");
        for(int i = 0; i<scores.length; i++){
            System.out.println(scores[i].getName() + ": " + scores[i].getScore());
        }
    }


}
