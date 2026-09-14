import java.util.Scanner;

public class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> account.showHistory();
                case 2 -> {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                }
                case 3 -> {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    account.deposit(amt);
                }
                case 4 -> {
                    System.out.print("Enter recipient ID: ");
                    String recId = sc.next();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    account.transfer(recId, amt);
                }
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
