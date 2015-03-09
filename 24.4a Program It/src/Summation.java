/*
 * Copyright (c) 2015. Nathan Johnson
 */

/**
 * Created by VHS on 3/9/2015.
 */

public class Summation {
    private static int low,high,result; //VARIABLES USED IN THIS CLASS.

//CONSTRUCTOR METHOD 1

    public Summation(){
        low=1;
        high=10;
        result = sum(low,high);
    }

//CONSTRUCTOR METHOD 2

    public Summation(int a, int b){
        low = a;
        high = b;
        result = sum(low,high);
    }

//STATIC METHOD FOR SUM

    private static int sum(int a, int b){
        int total = 0;
        if (a == b) {
            return b;
        }
        else {
            //System.out.println(a + " " + b);
            total = a + (sum(a + 1, b));
            return total;
        }
    }

    public String toString(){

        String a = "The recursive sum is: " + result;

        return a;

    }
}
