package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    boolean registerAccount(String accountNumber, String accountHolderName) throws RemoteException;
    boolean deposit(String accountNumber, double amount) throws RemoteException;
    boolean withdraw(String accountNumber, double amount) throws RemoteException;
    boolean transfer(String fromAccount, String toAccount, double amount) throws RemoteException;
}