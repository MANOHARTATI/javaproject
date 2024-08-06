import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for loan amount
        System.out.print("Enter the loan amount: ");
        double loanAmount = scanner.nextDouble();

        // Prompt user for annual interest rate
        System.out.print("Enter the annual interest rate (in %): ");
        double annualInterestRate = scanner.nextDouble();

        // Prompt user for loan term in years
        System.out.print("Enter the loan term (in years): ");
        int loanTermInYears = scanner.nextInt();

        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        // Convert loan term to months
        int loanTermInMonths = loanTermInYears * 12;

        // Calculate the monthly mortgage payment
        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTermInMonths);

        // Display the result
        System.out.printf("Your monthly mortgage payment is: %.2f\n", monthlyPayment);

        scanner.close();
    }

    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int loanTermInMonths) {
        return (loanAmount * monthlyInterestRate) /
               (1 - Math.pow(1 + monthlyInterestRate, -loanTermInMonths));
    }
}
