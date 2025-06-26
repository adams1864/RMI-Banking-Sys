# RMI Banking System

```
 /$$$$$$$  /$$      /$$ /$$$$$$       /$$$$$$$                      /$$       /$$                    
| $$__  $$| $$$    /$$$|_  $$_/      | $$__  $$                    | $$      |__/                    
| $$  \ $$| $$$$  /$$$$  | $$        | $$  \ $$  /$$$$$$  /$$$$$$$ | $$   /$$ /$$ /$$$$$$$   /$$$$$$ 
| $$$$$$$/| $$ $$/$$ $$  | $$        | $$$$$$$  |____  $$| $$__  $$| $$  /$$/| $$| $$__  $$ /$$__  $$
| $$__  $$| $$  $$$| $$  | $$        | $$__  $$  /$$$$$$$| $$  \ $$| $$$$$$/ | $$| $$  \ $$| $$  \ $$
| $$  \ $$| $$\  $ | $$  | $$        | $$  \ $$ /$$__  $$| $$  | $$| $$_  $$ | $$| $$  | $$| $$  | $$
| $$  | $$| $$ \/  | $$ /$$$$$$      | $$$$$$$/|  $$$$$$$| $$  | $$| $$ \  $$| $$| $$  | $$|  $$$$$$$
|__/  |__/|__/     |__/|______/      |_______/  \_______/|__/  |__/|__/  \__/|__/|__/  |__/ \____  $$
                                                                                            /$$  \ $$
                                                                                           |  $$$$$$/
                                                                                            \______/ 
```

---

## Features

- **Account Registration:** Create new bank accounts.
- **Deposit:** Deposit money into accounts.
- **Withdraw:** Withdraw money from accounts.
- **Transfer:** Transfer money between accounts.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- RMI Registry

### Setup Instructions

1. **Compile the Source Code:**
   ```sh
   cd simple-banking-system/src
   javac -cp ".;../lib/jansi-2.4.1.jar" server/*.java client/*.java common/*.java
   ```

2. **Start the RMI Registry:**
   ```sh
   start rmiregistry 2099
   ```

3. **Run the Server:**
   ```sh
   java -cp ".;../lib/jansi-2.4.1.jar" server.BankServer
   ```

4. **Run the Client:**
   ```sh
   java -cp ".;../lib/jansi-2.4.1.jar" client.BankClient
   ```

---

## Usage

Follow the prompts in the client application to register accounts and perform banking operations.
