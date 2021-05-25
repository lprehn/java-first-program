package com.h2;

import java.util.Map;
import java.util.Scanner;

/**
A class that calculates the best rates for loans
 */
public class BestLoanRates
{
    //a map of loan terms (in years) paired with the best loan
    //rates for the given term
    public static final Map<Integer, Float> bestRates =
            Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //greet the user
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

        //take loan term as input for rate calculation
        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();
        float bestRate = getRates(loanTermInYears);

        //if there is no best rate for the given term,
        //report this to the user
        if (bestRate==0.0f)
        {
            System.out.println("No available rates for term: " +
                    loanTermInYears + " years");
        }
        //otherwise, report the best rate
        else
        {
            System.out.println("Best Available Rate: " + bestRate + "%");
        }

        scanner.close();
    }

    //takes a loan term (in number of years) and returns the best
    //rate for the given term, if applicable
    public static float getRates(int loanTermInYears)
    {
        //if the given loan term has a corresponding rate...
        if (bestRates.containsKey(loanTermInYears)) {
            //return that rate
            return bestRates.get(loanTermInYears);
        }
        return 0.0f;
    }
}
