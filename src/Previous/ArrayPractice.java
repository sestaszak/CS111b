package Previous;

import java.util.*;

public class ArrayPractice {

    public static void main(String args[]){
        int[] a = {1, 0, -3, 400, -67, 23};

        int[] newa = absoluteValues(a);
        System.out.println("Started with " + a);
        System.out.println(newa);
    }

//    public static boolean playWithArrays() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Do you want to keep testing array methods? Which one?: ");
//
//
//    }

    public static int[] absoluteValues(int[] a){
        // Write a method named absoluteValues. It should accept an array of integers.
        // It should replace any negative values with the corresponding positive value.
        for(int index = 0; index < a.length; index++){
            if(a[index]<0){
                a[index] = 0 - a[index];
                System.out.println("Changed to " + a[index]);
            }
        }
        return a;
    }

//    public static int setArrayLen(){
//        Scanner input = new Scanner(System.in);
//        System.out.print("How many numbers do you want to include? How long of an array?: ");
//        int nn = input.nextInt();
//    }

    public static boolean allEqual(int[] a){
        boolean eqCheck;
        if(a.length == 1) {eqCheck = true;}
        else if(a.length == 0) {eqCheck = false;}
        else{
            eqCheck = true;
            for(int i = 1; i<a.length; i++){
                eqCheck = (a[i] == a[i-1]);
            }
        }

        return eqCheck;
    }


}
