package com.h2;

/**
 * An app that completes simple mathematical calculations
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    //a simple method that doubles the given number
    public static int doubleTheNumber(int number)
    {
        return (number*2);
    }

    //a simple method that takes a list of numbers and
    //returns the sum of all of the numbers in the list
    private static int add(int[] numbers)
    {
        int sum = 0;
        int length = numbers.length;
        //loop through each item in the list
        for (int num : numbers) {
            //add it to the sum
            sum += num;
        }
        return sum;
    }
}
