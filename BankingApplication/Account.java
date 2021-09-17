package BankingApplication;

public abstract class Account {

    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;
    private String userEmail;
    private String phoneNumber;

    // Default Constructor
    public Account() {

    }

    // Constructor of Account class.
    public Account(int accountNumber, String accountHolderName, double accountBalance, String userEmail,
            String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;

    }

    // abstract method
    public abstract void depositMoney(double amount);

    public abstract void withdrawMoney(double amount);

    public void accountInfo() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

        System.out.println("Account Holder Name : " + this.accountHolderName + "\nAccount Number : "
                + this.accountNumber + "\nUser Email Id : " + this.userEmail + "\nUser Phone : " + this.phoneNumber
                + "\nCurrent Balance : " + getAccountBalance());

    }

    // getters and setter for all variables.
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {

        if (accountBalance > 0)
            this.accountBalance = accountBalance;
        else
            System.out.println("Low Balance Operation Denied.");
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() == 10)
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Enter 10 Digit Phone Number Only.");
    }

}
