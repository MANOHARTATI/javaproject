import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for annual income
        System.out.print("Enter your annual income: ");
        double annualIncome = scanner.nextDouble();

        // Prompt user for deductions
        System.out.print("Enter your total deductions: ");
        double deductions = scanner.nextDouble();

        // Prompt user for filing status
        System.out.print("Enter your filing status (1 for Single, 2 for Married Filing Jointly, 3 for Married Filing Separately, 4 for Head of Household): ");
        int filingStatus = scanner.nextInt();

        // Prompt user for applicable tax credits
        System.out.print("Enter your total tax credits: ");
        double taxCredits = scanner.nextDouble();

        // Calculate taxable income
        double taxableIncome = annualIncome - deductions;

        // Calculate tax liability based on filing status and taxable income
        double taxLiability = calculateTaxLiability(taxableIncome, filingStatus);

        // Subtract tax credits from tax liability
        taxLiability -= taxCredits;

        // Ensure tax liability is not negative
        if (taxLiability < 0) {
            taxLiability = 0;
        }

        // Display the result
        System.out.printf("Your estimated tax liability is: %.2f\n", taxLiability);

        scanner.close();
    }

    public static double calculateTaxLiability(double taxableIncome, int filingStatus) {
        double taxLiability = 0;

        // Define tax brackets and rates for Single filing status (Example)
        double[] singleBrackets = {0, 9950, 40525, 86375, 164925, 209425, 523600};
        double[] singleRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

        // Define tax brackets and rates for Married Filing Jointly (Example)
        double[] marriedJointBrackets = {0, 19900, 81050, 172750, 329850, 418850, 628300};
        double[] marriedJointRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

        // Define tax brackets and rates for Married Filing Separately (Example)
        double[] marriedSeparateBrackets = {0, 9950, 40525, 86375, 164925, 209425, 314150};
        double[] marriedSeparateRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

        // Define tax brackets and rates for Head of Household (Example)
        double[] headOfHouseholdBrackets = {0, 14200, 54200, 86350, 164900, 209400, 523600};
        double[] headOfHouseholdRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

        double[] brackets;
        double[] rates;

        // Select the correct tax brackets and rates based on filing status
        switch (filingStatus) {
            case 1:
                brackets = singleBrackets;
                rates = singleRates;
                break;
            case 2:
                brackets = marriedJointBrackets;
                rates = marriedJointRates;
                break;
            case 3:
                brackets = marriedSeparateBrackets;
                rates = marriedSeparateRates;
                break;
            case 4:
                brackets = headOfHouseholdBrackets;
                rates = headOfHouseholdRates;
                break;
            default:
                System.out.println("Invalid filing status. Assuming Single filing status.");
                brackets = singleBrackets;
                rates = singleRates;
        }

        // Calculate tax liability based on the selected brackets and rates
        for (int i = brackets.length - 1; i > 0; i--) {
            if (taxableIncome > brackets[i]) {
                taxLiability += (taxableIncome - brackets[i]) * rates[i];
                taxableIncome = brackets[i];
            }
        }
        taxLiability += taxableIncome * rates[0]; // Tax on the first bracket

        return taxLiability;
    }
}
