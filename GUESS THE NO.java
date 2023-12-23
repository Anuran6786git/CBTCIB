import java.util.Random;
import java.util.Scanner;
public class GTN {
    private static final int M= 100;
    private static final int A = 6;
    private static final int R = 5;
    private int T;
    private int S;
    public GTN() {
        this.T = GRN();
        this.S= 0;
    }
    private int GRN() {
        Random random = new Random();
        return random.nextInt(M) + 1;
    }
    public void pG() {
        Scanner scanner = new Scanner(System.in);
        for (int r = 1; r <= R; r++) {
            System.out.println("\n ROUND " + r +":");
            int a = 0;
            int uG;
            do {
                System.out.print("\n Enter your guess: ");
                uG = scanner.nextInt();
                scanner.nextLine(); 
                a++;
                if (uG == T) {
                    System.out.println("Congratulations! You guessed the number in " + a + " attempts.");
                    int rS = A - a + 1;
                    S += rS;
                    System.out.println(" Round Score: " + rS);
                    break;
                } else if (uG < T) {
                    System.out.println(" The number is higher.Try again.");
                } else {
                    System.out.println(" The number is lower.Try again.");
                }
                if (a == A) {
                    System.out.println("Sorry, you've reached the maximum number of attempts,The correct number was " + T);
                }

            } while (a < A);
            if (r < R) {
                System.out.println("Current Total Score: " + S);
                System.out.print("Do you want to play the next round? (yes/no): ");
                String pNR = scanner.nextLine().toLowerCase();
                if (!pNR.equals("yes")) {
                    break;
                }
                T = GRN(); 
            }
        }
        System.out.println("\nGame Over! Your Total Score: " + S);
        scanner.close();
    }
    public static void main(String[] args) {
         System.out.print("--------------------------------");
         System.out.print("\n WELCOME TO GUESS-THE-NUMBER GAME ");
          System.out.print(" \n-------------------------------- ");
        GTN game = new GTN();
        game.pG();
    }
}