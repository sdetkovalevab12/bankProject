package BankGroupProject;

import java.io.*;
import java.util.*;
//comment
public class Bank {
    List <BankAccount> accounts = new ArrayList<>();

    //Adds a bank account to the accounts list.
    public void addAccount(BankAccount account){
        accounts.add(account);
    }

   public BankAccount getAccount(Long accountNumber) {
       for (BankAccount ba : accounts) {
           if (ba.getAccountNumber().equals(accountNumber))
               return ba;
       }
       return null;
   }

   public void  removeAccount(Long accountNumber){
        accounts.removeIf(bankAccount -> (accountNumber== bankAccount.getAccountNumber()));
   }
    // Remove a bank account by account number
//    public void removeAccount(Long accountNumber) {
//        BankAccount accountToRemove = getAccount(accountNumber);
//        if (accountToRemove != null) {
//            accounts.remove(accountToRemove);
//        }
//    }

    public void sortAccountsByName(){
        accounts.sort(Comparator.comparing(BankAccount::getAccountHolder));
    }
    // Sort accounts by account holder's name
//    public void sortAccountsByName() {
//        Collections.sort(accounts, Comparator.comparing(BankAccount::getAccountHolder));
//    }

    public void sortAccountsByAccountNumber(){
        accounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
    }

    public void readAccountsFromFile(String fileName) throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line=br.readLine()) != null){
                String[] account = line.split(",");
                if (account[0].equals("SavingsAccount")){
                    accounts.add(new SavingsAccount(Long.parseLong(account[1]), account[2], Double.parseDouble(account[3]), Double.parseDouble(account[4])));
                } else if (account[0].equals("CheckingAccount")) {
                    accounts.add(new CheckingAccount(Long.parseLong(account[1]), account[2], Double.parseDouble(account[3]), Double.parseDouble(account[4])));
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
       }finally{
           br.close();
        }
    }

//    public void readAccountsFromFile(String fileName) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 5) {
//                    String accountType = parts[0];
//                    Long accountNumber = Long.parseLong(parts[1]);
//                    String accountHolder = parts[2];
//                    Double balance = Double.parseDouble(parts[3]);
//                    Double additionalInfo = Double.parseDouble(parts[4]);
//                    if (accountType.equals("Savings")) {
//                        addAccount(new SavingsAccount(accountNumber, accountHolder, balance, additionalInfo));
//                    } else if (accountType.equals("Checking")) {
//                        addAccount(new CheckingAccount(accountNumber, accountHolder, balance, additionalInfo));
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void writeAccountsToFile(String fileName) throws IOException {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            for(BankAccount acc: accounts) {
                if(acc instanceof SavingsAccount){
                    bw.write("SavingsAccount"+acc.getAccountNumber()+","+acc.getAccountHolder()+","+acc.getBalance()+","+((SavingsAccount) acc).getInterestRate());
                    bw.newLine();
                }else if(acc instanceof CheckingAccount){
                    bw.write("CheckingAccount"+acc.getAccountNumber()+","+acc.getAccountHolder()+","+acc.getBalance()+","+((CheckingAccount) acc).getOverdraftLimit());
                    bw.newLine();
                }
            }
        }catch(IOException e){
            System.out.println("The path to a file is wrong or file does not exist.");
            e.printStackTrace();
        }finally{
            bw.close();
        }
    }



//   public void writeAccountsToFile(String fileName) throws IOException {
//       BufferedWriter bw = null;
//
//       try {
//           bw = new BufferedWriter(new FileWriter(fileName));
//           for(BankAccount acc: accounts) {
//               bw.write(acc.getClass()+","+acc.getAccountNumber()+","+acc.getAccountHolder()+","+acc.getBalance()+",");
//               bw.newLine();
//           }
//       }catch(IOException e){
//           System.out.println("The path to a file is wrong or file does not exist.");
//           e.printStackTrace();
//       }finally{
//           bw.close();
//       }
//   }

    public void viewAccounts(){
        accounts.forEach(System.out::println);
    }
    // Display all accounts
//    public void viewAccounts() {
//        for (BankAccount account : accounts) {
//            System.out.println(account);
//            System.out.println();
//        }
    }





