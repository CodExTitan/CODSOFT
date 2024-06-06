package InternshipCodes.atmInterface;

public class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double initialBalance, int pin) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }
}

