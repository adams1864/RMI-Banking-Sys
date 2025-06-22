package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.HashMap;
import common.Bank;
import common.Account;

public class BankImpl extends UnicastRemoteObject implements Bank {
    private Map<String, Account> accounts;

    public BankImpl() throws RemoteException {
        accounts = new HashMap<>();
    }

    @Override
    public boolean registerAccount(String accountNumber, String accountHolderName) throws RemoteException {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new Account(accountNumber, accountHolderName, 0));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deposit(String accountNumber, double amount) throws RemoteException {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean withdraw(String accountNumber, double amount) throws RemoteException {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return true;
            } 
        } 
        return false;
    }

    @Override
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) throws RemoteException {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                return true;
            } 
        } 
        return false;
    }
}