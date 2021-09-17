package BankingApplication;

public class SavingAccount extends Account {

    static String accountType;
    private static double interestRate;

    public String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        SavingAccount.accountType = accountType;
    }

    // Default Constructor
    public SavingAccount() {
        super();
    }

    public SavingAccount(int accountNumber, String accountHolderName, double accountBalance, String userEmail,
            String phoneNumber, String accountType, double interestRate) {
        super(accountNumber, accountHolderName, accountBalance, userEmail, phoneNumber);

        SavingAccount.accountType = accountType;
        SavingAccount.interestRate = interestRate;

    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        SavingAccount.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getAccountBalance() * interestRate;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        System.out.printf(
                "Interest Amount Of %.2f @ " + interestRate + " Percent Added To " + getAccountBalance() + "  ",
                interest);
        depositMoney(interest);
    }

    public void accountInfo() {
        super.accountInfo();
        System.out.println("Account Type: " + SavingAccount.accountType);
    }

    @Override
    public void depositMoney(double amount) {
        double currentBalance = getAccountBalance();
        if (amount > 0) {
            currentBalance += amount;
            setAccountBalance(currentBalance);
            System.out.println("Rs " + amount + " Deposited Successfully. ");
            System.out.println("Current Balance Is : " + currentBalance);
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        } else {
            System.out.println("Cannot Deposit Negative Amount. ");
        }

    }

    @Override
    public void withdrawMoney(double amount) {
        double currentBalance = getAccountBalance();
        if (amount > 0) {
            if (amount > currentBalance) {
                System.out.println("Insufficient Fund. ");
                System.out.println("Your Current Balance Is : " + currentBalance);
            } else {
                currentBalance -= amount;
                System.out.println("You've Successfully Withdraw Rs. " + amount);
                System.out.println("Your Current Balance Is : " + currentBalance);

            }
        } else {
            System.out.println("Negative Amount Cannot Be Withdraw. ");
        }
    }
}
