interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int number, String name, double balance) {
        this.accountNumber = number;
        this.holderName = name;
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { if (balance >= amount) balance -= amount; }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(int number, String name, double balance) { super(number, name, balance); }
    public double calculateInterest() { return getBalance() * 0.04; }
    public void applyForLoan(double amount) { System.out.println("Savings Account Loan Applied: " + amount); }
    public boolean calculateLoanEligibility() { return getBalance() > 5000; }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(int number, String name, double balance) { super(number, name, balance); }
    public double calculateInterest() { return getBalance() * 0.02; }
    public void applyForLoan(double amount) { System.out.println("Current Account Loan Applied: " + amount); }
    public boolean calculateLoanEligibility() { return getBalance() > 10000; }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(101, "Ravi", 6000);
        BankAccount acc2 = new CurrentAccount(102, "Neha", 15000);

        System.out.println("Interest (Savings): " + acc1.calculateInterest());
        System.out.println("Interest (Current): " + acc2.calculateInterest());
    }
}
