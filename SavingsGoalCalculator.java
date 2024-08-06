import java.util.Scanner;

public class SavingsGoalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the savings goal amount
        System.out.print("Enter your savings goal amount: ");
        double goalAmount = scanner.nextDouble();

        // Prompt user for the time frame in years
        System.out.print("Enter the time frame to achieve the goal (in years): ");
        int timeFrameInYears = scanner.nextInt();

        // Prompt user for the expected annual rate of return
        System.out.print("Enter the expected annual rate of return (in %): ");
        double annualRateOfReturn = scanner.nextDouble();

        // Convert annual rate of return to monthly rate of return
        double monthlyRateOfReturn = annualRateOfReturn / 100 / 12;

        // Convert time frame to months
        int timeFrameInMonths = timeFrameInYears * 12;

        // Calculate the required monthly investment
        double monthlyInvestment = calculateMonthlyInvestment(goalAmount, monthlyRateOfReturn, timeFrameInMonths);

        // Display the result
        System.out.printf("You need to invest: %.2f per month to reach your goal.\n", monthlyInvestment);

        scanner.close();
    }

    public static double calculateMonthlyInvestment(double goalAmount, double monthlyRateOfReturn, int timeFrameInMonths) {
        // Calculate monthly investment using the future value of an annuity formula
        return goalAmount * (monthlyRateOfReturn / (Math.pow(1 + monthlyRateOfReturn, timeFrameInMonths) - 1));
    }
}
