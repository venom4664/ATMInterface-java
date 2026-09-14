import java.util.Scanner;

public class Bank {
    private Account account;
    private ATM atm;

    public Bank() {
        account = new Account("12345", "1111", 1000.0);
        atm = new ATM(account);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User ID:");
        String userId = sc.nextLine();
        System.out.println("Enter PIN:");
        String pin = sc.nextLine();

        if (account.authenticate(userId, pin)) {
            atm.showMenu();
        } else {
            System.out.println("Access Denied!");
        }
        sc.close();
    }
}
