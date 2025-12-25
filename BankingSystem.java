import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankingSystem {

    static BankAccount[] accounts = new BankAccount[10];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- BANKING SYSTEM MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount(sc);
                case 2 -> depositAmount(sc);
                case 3 -> withdrawAmount(sc);
                case 4 -> displayAccount(sc);
                case 5 -> System.out.println("Thank you for using Banking System.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    static void createAccount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts[count++] = new BankAccount(accNo, name, balance);
        System.out.println("Account created successfully!");
    }

    static BankAccount findAccount(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    static void depositAmount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            acc.deposit(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdrawAmount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            acc.withdraw(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    static void displayAccount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found!");
        }
    }
}
