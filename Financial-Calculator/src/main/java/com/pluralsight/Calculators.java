package com.pluralsight;

import java.util.Scanner;

public class Calculators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which calculator would you like to use? (1 = Mortgage, 2= future value): ");
        int input = scanner.nextInt();
        if (input==1) {
            findMortgage();
        }  else if (input == 2) {
            findFutureValue();
        } else {
            System.out.printf("%d -- Invalid input!", input);
        }

    }
    public static void findMortgage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your principal amount (loan amount): ");
        double principal = scanner.nextDouble();
        System.out.print("Enter your interest rate: ");
        double interest = scanner.nextDouble();
        System.out.print("Enter the loan length (in years): ");
        int loanLength = scanner.nextInt();

        double monthlyInterestRate = interest/1200;
        double monthlyTotal = loanLength*12;
        double monthlyPayment = (principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,monthlyTotal))/(Math.pow(1+monthlyInterestRate,monthlyTotal)-1));
        double totalInterest = monthlyPayment * monthlyTotal - principal;

        System.out.printf("This is your monthly payment: "+  String.format("$%.2f\n", monthlyPayment));
        System.out.printf("This is you total interest rate: " + String.format("$%.2f",totalInterest));
    }

    public static void findFutureValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much is your deposit?: ");
        double depositAmt = scanner.nextDouble();
        System.out.print("What is your interest rate?: ");
        double interestRate = scanner.nextDouble();
        System.out.print("What is the number of years: ");
        double numOfYears = scanner.nextDouble();

        double dailyInterestRate = interestRate/100;
        //double dailyTotal = numOfYears*365;
        double futureValue = depositAmt * (Math.pow((1 + dailyInterestRate / 365), 365 * numOfYears));
        double totalInterest = futureValue - depositAmt;
        System.out.printf("Your total interest is: " + String.format("$%.2f \n", totalInterest));

        System.out.printf("This is your future amount: "+ String.format("$%.2f", futureValue));


    }
}
