import java.util.*;

public class CircleTester {
        public static void main(String args[]){
            // using xval, yval, r constructor
            Circle cir1 = new Circle(2, 3, .75);
            printInfo(cir1);
            // using point in constructor
            Point p2 = new Point(4, 3);
            Circle cir2 = new Circle(p2, 2);
            printInfo(cir2);
            // using xval, yval, r constructor, just for variety
            Circle cir3 = new Circle(7, 6, 2);
            printInfo(cir3);
            // copy constructor
            Circle cir4 = new Circle(cir1);
            printInfo(cir4);
            //check it equals what it was copied from
            System.out.println(cir4.equals(cir1));
            // no arg constructor
            Circle cir5 = new Circle();
            printInfo(cir5);

            System.out.println("Check cir1 for overlap with cir2: (true/false) " + cir1.doesOverlap(cir2));
            System.out.println("Check cir1 for overlap with cir3: (true/false) " + cir1.doesOverlap(cir3));
            System.out.println("Check cir1 for overlap with cir4: (true/false) " + cir1.doesOverlap(cir4));
            System.out.println("Check cir1 for overlap with cir5: (true/false) " + cir1.doesOverlap(cir5));
            System.out.println("Check cir2 for overlap with cir3: (true/false) " + cir2.doesOverlap(cir3));
            System.out.println("Check cir2 for overlap with cir4: (true/false) " + cir2.doesOverlap(cir4));
            System.out.println("Check cir2 for overlap with cir5: (true/false) " + cir2.doesOverlap(cir5));
            System.out.println("Check cir3 for overlap with cir4: (true/false) " + cir3.doesOverlap(cir4));
            System.out.println("Check cir3 for overlap with cir5: (true/false) " + cir3.doesOverlap(cir5));
            System.out.println("Check cir4 for overlap with cir5: (true/false) " + cir4.doesOverlap(cir5));

        }

        public static void printInfo(Circle cir){
            System.out.println(cir.toString() + " and area of " + cir.getArea());
        }

        public static void checkCircles(ArrayList<MyCircle> circles){
            int crntCt = 1;
            while(circles.size()>1){
                MyCircle crntTest = circles.get(0);

                for(int i=1; i<circles.size(); i++){
                    int [] compCt = {};
                    // TO FIX:
                    // array of original circle indeces?
                    // index to print out for comparison doesn't quite work (isn't helpful).
                    System.out.println("Comparing circle " + crntCt + " to circle " +  (i+1) + ", do they overlap? " + crntTest.doesOverlap(circles.get(i)));
                }
                circles.remove(0);
                crntCt++;
            }


        }



}
