package BankingApplication;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Account accountList[] = new Account[10];

        int numAccount = 0;
        int option;

        do {
            option = userMenu(scan);
            System.out.println();

            if (option == 1) {
                accountList[numAccount++] = createAccount(scan);
            } else if (option == 2) {
                depositMoney(accountList, scan);
            } else if (option == 3) {
                withdrawMoney(accountList, scan);
            } else if (option == 4) {
                applyInterest(accountList, scan);
            } else if (option == 5) {
                userAccountInfo(accountList, scan);
            } else {
                System.out.println("Thanks For Visiting. ");
            }
            System.out.println();
        } while (option != 6);

    }

    public static int accountType(Scanner scan) {
        System.out.println("Select Account Type : ");
        System.out.println("1. Current Account ");
        System.out.println("2. Saving Account ");

        int option;
        do {
            System.out.println("Enter Account Type : ");
            option = scan.nextInt();
        } while (option < 1 || option > 2);

        return option;
    }

    public static int searchAccount(Account accountList[], int accountNumber) {

        for (int index = 0; index < accountList.length;) {

            if (accountList[index].getAccountNumber() == accountNumber) {
                return index;
            }
            break;

        }

        return -1;
    }

    public static void depositMoney(Account accountList[], Scanner scan) {

        try {
            // Get accountNumber
            System.out.println("Please Enter Account Number : ");
            int accountNumber = scan.nextInt();

            // search for account
            int index = searchAccount(accountList, accountNumber);
            if (index >= 0) {
                System.out.println("Enter Amount To Be Deposit : ");
                double amount = scan.nextDouble();

                accountList[index].depositMoney(amount);

            } else {
                System.out.println("No Account Exist With Account Number ->: " + accountNumber);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void withdrawMoney(Account accountList[], Scanner scan) {

        try {
            // Get accountNumber
            System.out.println("Please Enter Account Number : ");
            int accountNumber = scan.nextInt();

            // search for account
            int index = searchAccount(accountList, accountNumber);

            if (index >= 0) {
                System.out.println("Enter Amount To Withdraw : ");
                double amount = scan.nextDouble();

                accountList[index].withdrawMoney(amount);

            } else {
                System.out.println("No Account Exist With Account Number ->: " + accountNumber);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void applyInterest(Account accountList[], Scanner scan) {

        // Get accountNumber
        System.out.println("Please Enter Account Number : ");
        int accountNumber = scan.nextInt();

        // search for account
        int index = searchAccount(accountList, accountNumber);
        if (index >= 0) {

            // Account Type Must Be Of Saving Account

            if (accountList[index] instanceof SavingAccount) {
                ((SavingAccount) accountList[index]).applyInterest();
            } else {
                System.out.println("Cannot Apply Interest On Current Account. ");
            }
        } else {
            System.out.println("No Account Exist With Account Number ->: " + accountNumber);
        }
    }

    public static Account createAccount(Scanner scan) {
        Account account = null;
        int option = accountType(scan);

        int accountNumber;
        System.out.println("Enter Account Number : ");
        accountNumber = scan.nextInt();

        final String currentAccount = "Current Account";
        final String savingAccount = "Saving Account";

        System.out.println("Enter Account Holder Name : ");
        String accountHolderName = scan.next();

        System.out.println("Enter Email Id : ");
        String userEmail = scan.next();

        System.out.println("Enter Phone Number : ");
        String phoneNumber = scan.next();

        if (option == 1) {
            // current account

            final double openingBalance = 2000;

            System.out.println("Enter Transaction Fee : ");
            double transactionFee = scan.nextDouble();

            account = new CurrentAccount();

            account.setAccountNumber(accountNumber);
            account.setAccountHolderName(accountHolderName);
            account.setUserEmail(userEmail);
            account.setPhoneNumber(phoneNumber);
            account.setAccountBalance(openingBalance);
            CurrentAccount.setTransactionFee(transactionFee);
            CurrentAccount.setAccountType(currentAccount);

        } else {
            // saving account

            double openingBalance = 500;

            System.out.println("Enter Interest Rate : ");
            double interestRate = scan.nextDouble();

            account = new SavingAccount();
            account.setAccountNumber(accountNumber);
            account.setAccountHolderName(accountHolderName);
            account.setUserEmail(userEmail);
            account.setPhoneNumber(phoneNumber);
            account.setAccountBalance(openingBalance);
            SavingAccount.setInterestRate(interestRate);
            SavingAccount.setAccountType(savingAccount);

        }

        return account;
    }

    public static void userAccountInfo(Account accountList[], Scanner scan) {

        try {
            // Get accountNumber
            System.out.println("Please Enter Account Number : ");
            int accountNumber = scan.nextInt();

            // search for accoun
            int index = searchAccount(accountList, accountNumber);

            if (index >= 0) {
                accountList[index].accountInfo();
            } else {
                System.out.println("No Account Exist With Account Number ->: " + accountNumber);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static int userMenu(Scanner scan) {
        System.out.println("Bank Account Menu ");
        System.out.println("1. Create New Account ");
        System.out.println("2. Deposit Funds ");
        System.out.println("3. Withdraw Funds ");
        System.out.println("4. Apply Interest ");
        System.out.println("5. Account Information ");
        System.out.println("6. Quit ");

        int option;
        do {
            System.out.print("Enter choice: ");
            option = scan.nextInt();
        } while (option < 1 || option > 6);

        return option;

    }

}
