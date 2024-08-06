import java.util.Scanner;

public class InvestmentReturnCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for initial investment amount
        System.out.print("Enter the initial investment amount: ");
        double initialInvestment = scanner.nextDouble();

        // Prompt user for expected annual rate of return
        System.out.print("Enter the expected annual rate of return (in %): ");
        double annualRateOfReturn = scanner.nextDouble();

        // Prompt user for investment time horizon in years
        System.out.print("Enter the investment time horizon (in years): ");
        int timeHorizonInYears = scanner.nextInt();

        // Calculate the future value of the investment
        double futureValue = calculateFutureValue(initialInvestment, annualRateOfReturn, timeHorizonInYears);

        // Display the result
        System.out.printf("The future value of your investment is: %.2f\n", futureValue);

        scanner.close();
    }

    public static double calculateFutureValue(double initialInvestment, double annualRateOfReturn, int timeHorizonInYears) {
        // Convert annual rate of return to a decimal
        double rateOfReturn = annualRateOfReturn / 100;

        // Calculate future value using compound interest formula
        return initialInvestment * Math.pow(1 + rateOfReturn, timeHorizonInYears);
    }
}
