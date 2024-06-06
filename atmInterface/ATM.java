package InternshipCodes.atmInterface;

import java.util.Scanner;


public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (authenticate()) {
                        withdraw();
                    }
                    break;
                case 2:
                    if (authenticate()) {
                        deposit();
                    }
                    break;
                case 3:
                    if (authenticate()) {
                        checkBalance();
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n\t\t\tATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: \n");
    }

    private boolean authenticate() {
        System.out.print("Enter your PIN: \n");
        int inputPin = scanner.nextInt();
        if (account.validatePin(inputPin)) {
            return true;
        } else {
            System.out.println("Invalid PIN. Please try again.");
            return false;
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: \n");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: \n");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000, 1234); // Initial balance and PIN
        ATM atm = new ATM(account);
        atm.start();
    }
}

