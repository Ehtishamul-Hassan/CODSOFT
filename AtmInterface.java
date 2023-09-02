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
            System.out.println("Withdrawn Successful: " + amount);
            System.out.println();
            System.out.println("Collect Your Cash");
            System.out.println("THANK YOU FOR  BANKING WITH US");
        }
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Amount must be greater than zero.");
        } else {
            int currentBalance = bankAccount.getAccountBalance();
            bankAccount.setAccountBalance(currentBalance + amount);
            System.out.println("Deposited: " + amount);
            System.out.println();
            System.out.println("THANK YOU FOR  BANKING WITH US");
        }
    }

    public void checkBalance() {
        int currentBalance = bankAccount.getAccountBalance();
        System.out.println("Account Balance: " + currentBalance);
        System.out.println();
        System.out.println("THANK YOU FOR  BANKING WITH US");
    }
}

public class AtmInterface {
    public static final String orginalUserId = "Hassan@764";
    public static final String orginalUserPasscode = "786901";

    //this method check whether the user id and passcode give by the user is correct or not 
    public static boolean validCredentials(String userId,String passcode) {
        return userId.equals(orginalUserId) && passcode.equals(orginalUserPasscode);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("WELOCME TO THE ATM");
        System.out.println("********************************");

        // Asking user for the User Id and Passcode
        System.out.print("Enter your User ID : ");
        String userId = sc.nextLine();
        System.out.print("Enter your Passcode : ");
        String passcode = sc.nextLine();

        // Validate the  Credentials 
        if(validCredentials(userId, passcode)) {
            System.out.println("Access Granted");
            System.out.println();

               // Initialize BankAccount with initial balance
        int initialBalance = 98533552;
        
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
            System.out.print("Enter your choice : ");
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
        else {
            System.out.println("Access denied. Please enter the correct credentials.");  
        }
    }
}
