class BankAccount {
    protected String customerName;
    protected int accountNumber;
    protected double balance;

    // Static data member for automatic account number generation
    static int nextAccountNumber = 1001;

    // Constructor
    BankAccount(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
        this.accountNumber = nextAccountNumber++;
    }

    // Deposit method
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Withdrawal method (to be overridden)
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Display account details
    void display() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: " + balance);
    }
}

// Savings Account class
class SavingsAccount extends BankAccount {

    SavingsAccount(String customerName, double balance) {
        super(customerName, balance);
    }

    // Overriding withdraw method
    @Override
    void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            System.out.println(amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Minimum balance of 500 must be maintained.");
        }
    }
}

// Current Account class
class CurrentAccount extends BankAccount {

    CurrentAccount(String customerName, double balance) {
        super(customerName, balance);
    }

    // Overriding withdraw method
    @Override
    void withdraw(double amount) {
        if (amount <= balance + 1000) {
            balance -= amount;
            System.out.println(amount + " withdrawn from Current Account.");
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {

        // Polymorphism
        BankAccount acc1 = new SavingsAccount("Anita", 5000);
        BankAccount acc2 = new CurrentAccount("John", 3000);

        // Operations on Savings Account
        acc1.display();
        acc1.deposit(1000);
        acc1.withdraw(5200);
        acc1.display();

        // Operations on Current Account
        acc2.display();
        acc2.deposit(500);
        acc2.withdraw(4000);
        acc2.display();
    }
}