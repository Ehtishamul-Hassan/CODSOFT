package CodSoftInternship;

import java.util.Scanner;

class BankAccount {
    private int accountBalance;

    public BankAccount(int initialBalance) {
        this.accountBalance = initialBalance;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(int amount) {
        int currentBalance = bankAccount.getAccountBalance();
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount, Amount must be greater than zero.");
        } else if (amount > currentBalance) {
            System.out.println("Withdrawal failed: Insufficient balance.");
        } else {
            bankAccount.setAccountBalance(currentBalance - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Amount must be greater than zero.");
        } else {
            int currentBalance = bankAccount.getAccountBalance();
            bankAccount.setAccountBalance(currentBalance + amount);
            System.out.println("Deposited: " + amount);
        }
    }

    public void checkBalance() {
        int currentBalance = bankAccount.getAccountBalance();
        System.out.println("Account Balance: " + currentBalance);
    }
}

public class AtmInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize BankAccount with initial balance
        System.out.print("Enter initial account balance: ");
        int initialBalance = sc.nextInt();
        BankAccount bankAccount = new BankAccount(initialBalance);

        // Initialize ATM with BankAccount
        ATM atm = new ATM(bankAccount);

        // User interface
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = sc.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = sc.nextInt();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
