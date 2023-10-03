package BankGroupProject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InsufficientFundsException, IOException {

        Bank bank=new Bank();
       Scanner scan =new Scanner(System.in);
       int choice=1;
       long accountNumber;
       String accountHolder;
       String fileName;
       double balance;
       double interestRate;
       double overdraftLimit;
       double amount;

        System.out.println("WELCOME TO BANK ACCOUNT MANAGEMENT APPLICATION!");

       while(choice<=9 && choice>0){

           System.out.println("1.Add Savings Account\n" +
                   "2.Add Checking Account\n" +
                   "3.Deposit Money\n" +
                   "4.Withdraw Money\n" +
                   "5.Sort Accounts by Name\n"+
                   "6.Sort accounts by account number\n"+
                   "7.Display Accounts\n" +
                   "8.Save Accounts to File\n" +
                   "9.Load Accounts from File\n" +
                   "0.Exit\n"+
                   "Enter your choice: ");
           choice=scan.nextInt();

           switch (choice){
               default:
                   System.out.println("Invalid input");
                   break;
               case 1:
                   System.out.println("Enter account number: ");
                   accountNumber = scan.nextLong();
                   System.out.println("Enter account holder name: ");
                   scan.nextLine();
                   accountHolder= scan.nextLine();
                   System.out.println("Enter initial balance: ");
                   balance=scan.nextDouble();
                   System.out.println("Enter Interest Rate: ");
                   interestRate=scan.nextDouble();
                   bank.addAccount(new SavingsAccount( accountNumber, accountHolder, balance, interestRate));
                   System.out.println("Savings account added successfully!");
                   break;
               case 2:
                   System.out.println("Enter account number: ");
                   accountNumber = scan.nextLong();
                   System.out.println("Enter account holder name: ");
                   scan.nextLine();
                   accountHolder= scan.nextLine();
                   System.out.println("Enter initial balance: ");
                   balance=scan.nextDouble();
                   System.out.println("Enter overdraft limit: ");
                   overdraftLimit=scan.nextDouble();
                   bank.addAccount(new CheckingAccount(accountNumber, accountHolder, balance, overdraftLimit));
                   System.out.println("Checking account added successfully!");
                   break;
               case 3:
                   System.out.println("Enter account number: ");
                   accountNumber = scan.nextLong();
                   System.out.println("Enter amount to deposit: ");
                   amount=scan.nextDouble();
                   bank.getAccount(accountNumber).deposit(amount);
                   System.out.println("The deposit was successful!");
                   break;
               case 4:
                   System.out.println("Enter account number: ");
                   accountNumber = scan.nextLong();
                   System.out.println("Enter amount to withdraw");
                   amount= scan.nextDouble();
                   bank.getAccount(accountNumber).withdraw(amount);
                   System.out.println("Withdraw went successful");
                   break;
               case 5:
                   bank.sortAccountsByName();
                   System.out.println("Accounts are sorted by name successfully");
               case 6:
                   bank.sortAccountsByAccountNumber();
                   System.out.println("Accounts are sorted by account number successfully");
                   break;
               case 7:
                   bank.viewAccounts();
                   break;
               case 8:
                   System.out.println("Enter the file name: ");
                   scan.nextLine();
                   fileName=scan.nextLine();
                   bank.writeAccountsToFile(fileName);
                   break;

               case 9:
                   System.out.println("Enter the file name: ");
                   scan.nextLine();
                   fileName=scan.nextLine();
                   bank.readAccountsFromFile(fileName);
                   System.out.println("the accounts are loaded");
                   break;

               case 0:
                   System.out.println("Thank you! Goodbye!");
                    System.exit(0);
           }




       }
    }
}
