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
        double monthlyTotalMonth = loanLength*12;
        double monthlyPayment = (principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,monthlyTotalMonth))/(Math.pow(1+monthlyInterestRate,monthlyTotalMonth)-1));
        double totalInterest = monthlyPayment * monthlyTotalMonth - principal;

        System.out.printf("This is your monthly payment: "+  String.format("$%.2f\n", monthlyPayment));
        System.out.printf("This is you total interest rate: " + String.format("$%.2f",totalInterest));
    }

    public static void findFutureValue() {

    }
}
