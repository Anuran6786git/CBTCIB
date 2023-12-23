import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Ai {
    private static final String[] UI = {"6534", "6542", "3475", "2974", "7124"};
    private static final String[] P = {"7542", "2178", "9123", "8324", "6534"};
    private double bal;
    private List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Ai ai = new Ai();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("WELCOME TO THE ATM");
        System.out.println("\n-----------------");
        System.out.print("Please enter your user id: ");
        String ud = scanner.nextLine();
        System.out.print("Please enter your pin: ");
        String p = scanner.nextLine();
        boolean isValid = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ud.equals(UI[i]) && p.equals(P[j])) {
                    isValid = true;
                    break;
                }
            }
        }
        if (!isValid) {
            System.out.println("You have entered Invalid user id or pin");
            return;
        }
        while (true) {
            System.out.println("\n-------------------");
            System.out.println("\nATM Menu:");
            System.out.println("\n--------------------");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    ai.TH();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double wA = scanner.nextDouble();
                    ai.W(wA);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double dA = scanner.nextDouble();
                    ai.D(dA);
                    break;
                case 4:
                    System.out.print("Enter the amount to transfer: ");
                    double tA = scanner.nextDouble();
                    System.out.print("Please enter the recipient's account number: ");
                    String r = scanner.next();
                    ai.T(tA, r);
                    break;
                case 5:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    public void TH() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public void W(double A) {
        if (bal >= A) {
            bal -= A;
            String transaction = "Withdraw: Rs" + A + " - New balance: Rs" + bal;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    public void D(double A) {
        bal += A;
        String transaction = "Deposit: Rs" + A + " - New balance: Rs" + bal;
        transactionHistory.add(transaction);
        System.out.println(transaction);
    }
    public void T(double A, String recipient) {
        if (bal >= A) {
            bal -= A;
            String transaction = "Transfer: Rs" + A + " to account " + recipient + " - New balance: Rs" + bal;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}