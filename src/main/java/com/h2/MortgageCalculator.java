package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate)
    {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    public static void main(String[] args) {
        //create variables from input
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        //calculate mortgage
        MortgageCalculator calculator =
                new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();

        //print results
        System.out.println(calculator.toString());
    }

    //calculate the necessary monthly payments for the mortgage
    public void calculateMonthlyPayment()
    {
        //assign the variables for the mathematical calculation
        double monthlyPayment;
        long p = loanAmount;
        //the monthly interest rate
        float r = getMonthlyInterestRate();
        //the number of payments
        int n = getNumberOfPayments();

        //math
        monthlyPayment = p*(r*(Math.pow((r+1),n)))/(Math.pow((r+1),n)-1);

        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    //calculate the number of payments necessary for the mortgage
    private int getNumberOfPayments()
    {
        return (termInYears*12);
    }

    //calculate the monthly interest rate using the annual rate
    private float getMonthlyInterestRate()
    {
        float interestRate = annualRate/100;
        interestRate /= 12;
        return interestRate;
    }
}
