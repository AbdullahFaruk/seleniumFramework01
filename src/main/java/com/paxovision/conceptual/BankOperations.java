package com.paxovision.conceptual;

import java.util.Scanner;

/**
 * Created by Abdullah Al Faruk on 3/20/16.
 */
public class BankOperations {

    public static void main(String[] args) {

        System.out.println("--------------------" + " Welcome to Paxo Bank" + " --------------------");
        Scanner in = new Scanner(System.in);
        int userChoice;
        boolean quit = false;
        float balance = 0;

        do {
            System.out.println("Please Select a Transaction by Typing number");
            System.out.println("Please Type: " + "1. Deposit money");
            System.out.println("Please Type: " + "2. Withdraw money");
            System.out.println("Please Type: " + "3. Check balance");
            System.out.print("Please Type: " +  "0. to quit: ");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    float amount;
                    System.out.print("Amount to deposit: " + "$");
                    amount = in.nextFloat();
                    if (amount <= 0)
                        System.out.println("Can't deposit non-positive amount.");
                    else {
                        balance += amount;
                        System.out.println("$" + amount + " has been deposited.");
                    }
                    break;
                case 2:
                    System.out.print("Amount to withdraw: ");
                    amount = in.nextFloat();
                    if (amount <= 0 || amount > balance)
                        System.out.println("Withdrawal can't be completed.");
                    else {
                        balance -= amount;
                        System.out.println("$" + amount + " has been withdrawn.");
                    }
                    break;
                case 3:
                    System.out.println("Your balance: $" + balance);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
            System.out.println();
        } while (!quit);
        System.out.println("Bye!");
    }





}
