package atmInterface;

import java.util.Scanner;

// ATM interface
interface ATMInterface {

    void checkBalance();

    void deposit(double amount);

    void withdraw(double amount);
}

// UserAccount class implementing ATM interface
class UserAccount implements ATMInterface {
    private double balance;

    public UserAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void checkBalance() {
        System.out.println("Current balance: Rs. " + balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount; // balance = balance + amount
        System.out.println("Rs. " + amount + " deposited successfully.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount; // balance = balance - amount
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance. Unable to withdraw Rs. " + amount);
        }
    }
}

// Main class
public class ATM {
    public static void main(String args[]) {
        // Creating a user account with balance Rs. 1,00,000
        UserAccount account = new UserAccount(100000.0);

        // Using ATM methods based on user input
        Scanner sc = new Scanner(System.in);

        int option;
        double amount;

        System.out.println("Welcome to Java ATM" + "\n");

        // A do-while loop is used to use all the methods present
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("\n" + "Please select an option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    amount = sc.nextDouble();
                    account.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = sc.nextDouble();
                    account.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the Services" + "\n"
                    + "Visit Again...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); // line break
        } while (option != 4);

        sc.close();
    }
}
