package BankingApplication;

public class CurrentAccount extends Account {

    static String accountType;
    private static double transactionFee = 2.5;

    public CurrentAccount() {

    }

    public CurrentAccount(int accountNumber, String accountHolderName, double accountBalance, String userEmail,
            String phoneNumber, String accountType, double transactionFee) {
        super(accountNumber, accountHolderName, accountBalance, userEmail, phoneNumber);

        CurrentAccount.accountType = accountType;
        CurrentAccount.transactionFee = transactionFee;
    }

    public String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        CurrentAccount.accountType = accountType;
    }

    public static double getTransactionFee() {
        return transactionFee;
    }

    public static void setTransactionFee(double transactionFee) {
        CurrentAccount.transactionFee = transactionFee;
    }

    public void accountInfo() {
        super.accountInfo();
        System.out.println("Account Type: " + accountType);
    }

    @Override
    public void depositMoney(double amount) {
        double currentBalance = getAccountBalance();
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Rs " + amount + " Deposited Successfully. ");

            currentBalance -= transactionFee;
            setAccountBalance(currentBalance);
            System.out.printf("Transaction Fee %.2f Applied ", transactionFee);

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
            if (amount + transactionFee > currentBalance) {
                System.out.println("Insufficient Fund. ");
                System.out.println("Your Current Balance Is : " + currentBalance);
            } else {
                currentBalance -= amount;
                currentBalance -= transactionFee;
                System.out.println("You've Successfully Withdraw Rs. " + amount);
                System.out.println("Your Current Balance After Deducting Transaction Fee Is : " + currentBalance);

            }
        } else {
            System.out.println("Negative Amount Cannot Be Withdraw. ");
        }

    }

}
