import java.util.Scanner;

public class LoanInterest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double principal, time, rate, SI;

        // Input
        System.out.print("Enter Principal Amount: ");
        principal = sc.nextDouble();

        System.out.print("Enter Time in years: ");
        time = sc.nextDouble();

        // Determine interest rate
        if (principal < 50000) {
            rate = 5;
        }

        else if (principal >= 50000 && principal <= 100000) {
            rate = 7;
        }

        else {
            rate = 10;
        }

        // Calculate Simple Interest
        SI = (principal * rate * time) / 100;

        // Display results
        System.out.println("Interest Rate Applied = " + rate + "%");
        System.out.println("Simple Interest = sh" + SI);

        sc.close();
    }
}