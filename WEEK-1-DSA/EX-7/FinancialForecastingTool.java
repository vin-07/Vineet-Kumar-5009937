public class FinancialForecastingTool {

    // Recursive method to calculate the future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if years is 0, return the present value
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05;     // 5% annual growth rate
        int years = 10;               // Number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("The future value of the investment after %d years is: $%.2f%n", years, futureValue);
    }
}
