import java.util.Map;
public class CarsAssemble {

    // number of cars produced per hour as per instructions
    private static final double CARS_PER_HOUR = 221.0;

    // success rate map based on speed 
    private final Map<Integer, Double> successRateMap = Map.of(
            1, 1.0,
            2, 1.0,
            3, 1.0,
            4, 1.0,
            5, 0.9,
            6, 0.9,
            7, 0.9,
            8, 0.9,
            9, 0.8,
            10, 0.77
        );

    /**
     * Returns the number of cars produced per hour based on the speed
     * @param speed the speed of the production line
     * @return the number of cars produced per hour adjusted for the success rate
     */
    public double productionRatePerHour(int speed) {
        return CARS_PER_HOUR * speed * successRate(speed);
    }

    /**
     * Returns the number of cars produced per minute based on the speed
     * @param speed the speed of the production line
     * @return the number of cars produced per minute adjusted for the success rate
     */
    public int workingItemsPerMinute(int speed) {
        return (int) this.productionRatePerHour(speed) / 60;
    }

    /**
     * Returns the success rate of the production line based on the speed
     * @param speed the speed of the production line
     * @return the success rate
     */
    private double successRate(int speed) {
        return this.successRateMap.getOrDefault(speed, 0.0);
    }
}
