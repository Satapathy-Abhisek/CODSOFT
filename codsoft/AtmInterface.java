import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void menu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: Rs." + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs.");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Transaction successful. Your update balance: Rs." + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double withdrawalAmount = sc.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Transaction successful. Your update balance: Rs." + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance!!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you.Have a good day.");
                    return;
                default:
                    System.out.println("Invalid choice. Enter a valid option.");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String args[]) {
        BankAccount user = new BankAccount(2000.0);
        ATM atm = new ATM(user);
        atm.run();

    }
}
