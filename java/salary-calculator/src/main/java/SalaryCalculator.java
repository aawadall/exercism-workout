public class SalaryCalculator {
    // magic numbers 
    private final static int DAYS_SKIPPED_THRESHOLD = 5;
    private final static double BASE_MULTIPLIER = 1.0;
    private final static double PENALTY = 0.15;
    private final static int BASE_MULTIPLIER_PER_PRODUCT_SOLD = 10;
    private final static int SOLD_ITEMS_THRESHOLD = 20;
    private final static int ABOVE_SALES_MULITPLIER = 13;
    private final static double BASE_SALARY = 1000.0;
    private final static double MAX_SALARY = 2000.0;
    /**
     * Calculate the multiplier for the salary based on the number of days skipped
     * @param daysSkipped the number of days skipped
     * @return the multiplier for the salary
     */
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > DAYS_SKIPPED_THRESHOLD ? 
            penalizeSalary() : 
            BASE_MULTIPLIER;
    }

    /**
     * Calculate the multiplier for the salary based on the number of products sold
     * @param productsSold the number of products sold
     * @return the multiplier for the salary
     */
    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > SOLD_ITEMS_THRESHOLD ? 
            ABOVE_SALES_MULITPLIER : 
            BASE_MULTIPLIER_PER_PRODUCT_SOLD;
    }

    /**
     * Calculate the bonus for the salary based on the number of products sold
     * @param productsSold the number of products sold
     * @return the bonus for the salary
     */
    public double bonusForProductSold(int productsSold) {
        return multiplierPerProductsSold(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        var proposedSalary = BASE_SALARY * multiplierPerDaysSkipped(daysSkipped) + bonusForProductSold(productsSold);
        return proposedSalary > MAX_SALARY ?
            MAX_SALARY :
            proposedSalary;
    } 

    /**
     * Penalize the salary by the penalty amount
     * @return the penalized salary
     */
    private double penalizeSalary() {
        return BASE_MULTIPLIER - PENALTY;
    }
}
