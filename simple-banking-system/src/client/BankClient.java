package client;

import common.Bank;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

// Jansi imports
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.ansi;

public class BankClient {
    private Bank bank;

    public BankClient(Bank bank) {
        this.bank = bank;
    }

    public void registerAccount(String accountNumber, String accountHolderName) {
        try {
            boolean success = bank.registerAccount(accountNumber, accountHolderName);
            if (success) {
                System.out.println(ansi().fgBrightGreen().a("Account registered successfully.").reset());
            } else {
                System.out.println(ansi().fgBrightRed().a("Account registration failed.").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi().fgBrightRed().a("Error during account registration: " + e.getMessage()).reset());
        }
    }

    public void deposit(String accountNumber, double amount) {
        try {
            boolean success = bank.deposit(accountNumber, amount);
            if (success) {
                System.out.println(ansi().fgBrightGreen().a("Deposit successful.").reset());
            } else {
                System.out.println(ansi().fgBrightRed().a("Deposit failed.").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi().fgBrightRed().a("Error during deposit: " + e.getMessage()).reset());
        }
    }

    public void withdraw(String accountNumber, double amount) {
        try {
            boolean success = bank.withdraw(accountNumber, amount);
            if (success) {
                System.out.println(ansi().fgBrightGreen().a("Withdrawal successful.").reset());
            } else {
                System.out.println(ansi().fgBrightRed().a("Withdrawal failed.").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi().fgBrightRed().a("Error during withdrawal: " + e.getMessage()).reset());
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        try {
            boolean success = bank.transfer(fromAccount, toAccount, amount);
            if (success) {
                System.out.println(ansi().fgBrightGreen().a("Transfer successful.").reset());
            } else {
                System.out.println(ansi().fgBrightRed().a("Transfer failed.").reset());
            }
        } catch (Exception e) {
            System.out.println(ansi().fgBrightRed().a("Error during transfer: " + e.getMessage()).reset());
        }
    }

    public static void main(String[] args) {
        // Install Jansi
        AnsiConsole.systemInstall();
        System.out.println(ansi().fgBrightGreen().a(
            " /$$$$$$$  /$$      /$$ /$$$$$$       /$$$$$$$                      /$$       /$$                    \n" +
            "| $$__  $$| $$$    /$$$|_  $$_/      | $$__  $$                    | $$      |__/                    \n" +
            "| $$  \\ $$| $$$$  /$$$$  | $$        | $$  \\ $$  /$$$$$$  /$$$$$$$ | $$   /$$ /$$ /$$$$$$$   /$$$$$$ \n" +
            "| $$$$$$$/| $$ $$/$$ $$  | $$        | $$$$$$$  |____  $$| $$__  $$| $$  /$$/| $$| $$__  $$ /$$__  $$\n" +
            "| $$__  $$| $$  $$$| $$  | $$        | $$__  $$  /$$$$$$$| $$  \\ $$| $$$$$$/ | $$| $$  \\ $$| $$  \\ $$\n" +
            "| $$  \\ $$| $$\\  $ | $$  | $$        | $$  \\ $$ /$$__  $$| $$  | $$| $$_  $$ | $$| $$  | $$| $$  | $$\n" +
            "| $$  | $$| $$ \\/  | $$ /$$$$$$      | $$$$$$$/|  $$$$$$$| $$  | $$| $$ \\  $$| $$| $$  | $$|  $$$$$$$\n" +
            "|__/  |__/|__/     |__/|______/      |_______/  \\_______/|__/  |__/|__/  \\__/|__/|__/  |__/ \\____  $$\n" +
            "                                                                                            /$$  \\ $$\n" +
            "                                                                                           |  $$$$$$/\n" +
            "                                                                                            \\______/ \n"
        ).reset());
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2099);
            Bank bank = (Bank) registry.lookup("Bank");
            BankClient client = new BankClient(bank);
            Scanner scanner = new Scanner(System.in);
            String choice;

            do {
                System.out.println(ansi().fgBrightCyan().a("+--------------------------------------+").reset());
                System.out.println(ansi().fgBrightCyan().a("|      ").a(ansi().fgBrightYellow().a("Welcome to RMI Bank System")).a(ansi().fgBrightCyan().a("      |")).reset());
                System.out.println(ansi().fgBrightCyan().a("+--------------------------------------+").reset());
                System.out.println(ansi().fgBrightGreen().a("| 1. Register Account                  |").reset());
                System.out.println(ansi().fgBrightGreen().a("| 2. Deposit                           |").reset());
                System.out.println(ansi().fgBrightGreen().a("| 3. Withdraw                          |").reset());
                System.out.println(ansi().fgBrightGreen().a("| 4. Transfer                          |").reset());
                System.out.println(ansi().fgBrightRed().a("| 5. Exit                              |").reset());
                System.out.println(ansi().fgBrightCyan().a("+--------------------------------------+").reset());
                System.out.print(ansi().fgBrightYellow().a("Choose an option: ").reset());
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print(ansi().fgBrightMagenta().a("Enter account number: ").reset());
                        String accountNumber = scanner.nextLine();
                        System.out.print(ansi().fgBrightMagenta().a("Enter account holder name: ").reset());
                        String accountHolderName = scanner.nextLine();
                        client.registerAccount(accountNumber, accountHolderName);
                        break;
                    case "2":
                        System.out.print(ansi().fgBrightMagenta().a("Enter account number: ").reset());
                        accountNumber = scanner.nextLine();
                        System.out.print(ansi().fgBrightMagenta().a("Enter amount to deposit: ").reset());
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        client.deposit(accountNumber, depositAmount);
                        break;
                    case "3":
                        System.out.print(ansi().fgBrightMagenta().a("Enter account number: ").reset());
                        accountNumber = scanner.nextLine();
                        System.out.print(ansi().fgBrightMagenta().a("Enter amount to withdraw: ").reset());
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        client.withdraw(accountNumber, withdrawAmount);
                        break;
                    case "4":
                        System.out.print(ansi().fgBrightMagenta().a("Enter from account number: ").reset());
                        String fromAccount = scanner.nextLine();
                        System.out.print(ansi().fgBrightMagenta().a("Enter to account number: ").reset());
                        String toAccount = scanner.nextLine();
                        System.out.print(ansi().fgBrightMagenta().a("Enter amount to transfer: ").reset());
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        client.transfer(fromAccount, toAccount, transferAmount);
                        break;
                    case "5":
                        System.out.println(ansi().fgBrightRed().a("Exiting... Thank you for using RMI Bank!").reset());
                        break;
                    default:
                        System.out.println(ansi().fgBrightYellow().a("Invalid option. Please try again.").reset());
                }
            } while (!choice.equals("5"));

            scanner.close();
        } catch (Exception e) {
            System.out.println(ansi().fgBrightRed().a("Client exception: " + e.getMessage()).reset());
        } finally {
            // Uninstall Jansi
            AnsiConsole.systemUninstall();
        }
    }
}