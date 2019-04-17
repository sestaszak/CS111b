package Previous;

import java.util.*;
public class MyCircleTester {
    public static void main(String args[]){
        MyCircle cir1 = makeCircle(2, 3, .75);
        MyCircle cir2 = makeCircle(4, 3, 2);
        MyCircle cir3 = makeCircle(7, 6, 2);
        MyCircle cir4 = makeCircle(8, 9, 1);

        System.out.println("Check cir1 for overlap with cir2: (true/false) " + cir1.doesOverlap(cir2));
        System.out.println("Check cir1 for overlap with cir3: (true/false) " + cir1.doesOverlap(cir3));
        System.out.println("Check cir1 for overlap with cir4: (true/false) " + cir1.doesOverlap(cir4));
        System.out.println("Check cir2 for overlap with cir3: (true/false) " + cir2.doesOverlap(cir3));
        System.out.println("Check cir2 for overlap with cir4: (true/false) " + cir2.doesOverlap(cir4));
        System.out.println("Check cir3 for overlap with cir4: (true/false) " + cir3.doesOverlap(cir4));


//        ArrayList<MyCircle> cirList = new ArrayList<>(Arrays.asList(cir1, cir2, cir3, cir4));
//        checkCircles(cirList);
    }

    public static MyCircle makeCircle(double x, double y, double r){
        MyCircle circle = new MyCircle();
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(r);

        System.out.println("Your circle created with radius " + circle.getRadius() + " and area " + circle.getArea() + " centered at (" + circle.getX() + ", " + circle.getY() + ")");
        return circle;
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
