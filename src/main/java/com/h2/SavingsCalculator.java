package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator
{
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits)
    {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {
        //take the command line arguments and split them up
        //into the credits and debits
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        //create the lists of floats that will be populated
        //with the values in the lists of strings
        float[] credits = new float[creditsAsString.length];
        float[] debits = new float[debitsAsString.length];

        for(int i=0;i<creditsAsString.length;i++)
        {
            //transform each string in the list of credits into a float
            //and add the value to the list of floats
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for(int i=0;i<debitsAsString.length;i++)
        {
            //do the same with the list of debits
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credits, debits);

        float netSavings = calculator.calculate();

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " +
                remainingDaysInMonth(LocalDate.now()));
    }

    //a method to sum together all of the user's credits
    private float sumOfCredits()
    {
        float sum = 0.0f;
        //for each credit...
        for (float credit : credits)
        {
            //add it to the overall sum
            sum += credit;
        }
        return sum;
    }

    //a method to sum together all of the user's debits
    private float sumOfDebits()
    {
        float sum = 0.0f;
        //for each debit...
        for (float debit : debits)
        {
            //add it to the sum
            sum += debit;
        }
        return sum;
    }

    //takes a date and calculates how many days are
    //remaining in the current month
    private static int remainingDaysInMonth(LocalDate date)
    {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        return (totalDaysInMonth - date.getDayOfMonth());
    }

    //calculates the user's savings given their credits and debits
    public float calculate()
    {
        return (sumOfCredits() - sumOfDebits());
    }
}
