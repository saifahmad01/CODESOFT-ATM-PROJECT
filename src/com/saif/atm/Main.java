package com.saif.atm;

import java.util.Scanner;

import com.saif.atm.util.InputValidator;
import com.saif.atm.model.BankAccount;
import com.saif.atm.service.ATM;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0); // Starting with ₹1000
        ATM atm = new ATM(account);

        int choice;

        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (InputValidator.isValidAmount(depositAmount)) {
                        atm.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (InputValidator.isValidAmount(withdrawAmount)) {
                        atm.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive number.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

