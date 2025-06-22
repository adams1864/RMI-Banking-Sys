package client;

import common.Bank;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class BankClient {
    private Bank bank;

    public BankClient(Bank bank) {
        this.bank = bank;
    }

    public void registerAccount(String accountNumber, String accountHolderName) {
        try {
            boolean success = bank.registerAccount(accountNumber, accountHolderName);
            if (success) {
                System.out.println("Account registered successfully.");
            } else {
                System.out.println("Account registration failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during account registration: " + e.getMessage());
        }
    }

    public void deposit(String accountNumber, double amount) {
        try {
            boolean success = bank.deposit(accountNumber, amount);
            if (success) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Deposit failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    public void withdraw(String accountNumber, double amount) {
        try {
            boolean success = bank.withdraw(accountNumber, amount);
            if (success) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Withdrawal failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        try {
            boolean success = bank.transfer(fromAccount, toAccount, amount);
            if (success) {
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Transfer failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during transfer: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2099);
            Bank bank = (Bank) registry.lookup("Bank");
            BankClient client = new BankClient(bank);
            Scanner scanner = new Scanner(System.in);
            String choice;

            do {
                System.out.println("1. Register Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();
                        client.registerAccount(accountNumber, accountHolderName);
                        break;
                    case "2":
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextLine();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        client.deposit(accountNumber, depositAmount);
                        break;
                    case "3":
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextLine();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        client.withdraw(accountNumber, withdrawAmount);
                        break;
                    case "4":
                        System.out.print("Enter from account number: ");
                        String fromAccount = scanner.nextLine();
                        System.out.print("Enter to account number: ");
                        String toAccount = scanner.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        client.transfer(fromAccount, toAccount, transferAmount);
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (!choice.equals("5"));

            scanner.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}