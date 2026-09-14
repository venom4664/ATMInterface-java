import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> history;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            history.add(new Transaction("Withdraw", amt));
            System.out.println("Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void deposit(double amt) {
        balance += amt;
        history.add(new Transaction("Deposit", amt));
        System.out.println("Deposit successful. Balance: " + balance);
    }

    public void transfer(String recId, double amt) {
        if (amt <= balance) {
            balance -= amt;
            history.add(new Transaction("Transfer to " + recId, amt));
            System.out.println("Transfer successful. Balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void showHistory() {
        System.out.println("Transaction History:");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }
}

