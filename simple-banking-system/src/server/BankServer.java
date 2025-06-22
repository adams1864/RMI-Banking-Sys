package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {
    public static void main(String[] args) {
        try {
            BankImpl bankImpl = new BankImpl();
           Registry registry = LocateRegistry.createRegistry(2099);
            registry.rebind("Bank", bankImpl);
            System.out.println("Bank server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}