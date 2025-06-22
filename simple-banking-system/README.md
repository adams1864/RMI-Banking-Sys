# Simple Banking System

This project implements a simple banking system using Java and Remote Method Invocation (RMI). It allows users to register accounts, deposit money, withdraw funds, and transfer money between accounts.

## Project Structure

```
simple-banking-system
├── src
│   ├── server
│   │   ├── BankServer.java
│   │   └── BankImpl.java
│   ├── client
│   │   └── BankClient.java
│   ├── common
│   │   ├── Bank.java
│   │   └── Account.java
```

## Features

- **Account Registration**: Users can create new bank accounts.
- **Deposit**: Users can deposit money into their accounts.
- **Withdraw**: Users can withdraw money from their accounts.
- **Transfer**: Users can transfer money between accounts.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- RMI Registry

### Setup Instructions

1. **Compile the Source Code**:
   Navigate to the `src` directory and compile the Java files:
   ```
   javac server/*.java client/*.java common/*.java
   ```

2. **Start the RMI Registry**:
   Open a terminal and start the RMI registry:
   ```
   rmiregistry
   ```

3. **Run the Server**:
   In another terminal, run the server:
   ```
   java server.BankServer
   ```

4. **Run the Client**:
   In a separate terminal, run the client:
   ```
   java client.BankClient
   ```

### Usage

Follow the prompts in the client application to register accounts and perform banking operations.

## License

This project is licensed under the MIT License.