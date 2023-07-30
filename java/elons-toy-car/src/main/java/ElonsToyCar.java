public class ElonsToyCar {
    private int distanceDriven = 0;
    private int batteryRemaining = 100;

    // magic numbers 
    private static final int BATTERY_DECAY_PER_DRIVE = 1;
    private static final int DISTANCE_PER_DRIVE = 20;
    private static final int LOW_BATTERY_THRESHOLD = 0;
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distanceDriven);
    }

    public String batteryDisplay() {
        var display = batteryRemaining > LOW_BATTERY_THRESHOLD ? String.format("at %d%%", batteryRemaining) : "empty";
        return String.format("Battery %s", display);
    }

    public void drive() {
        updateDistance();
        updateBattery();
    }

    private void updateDistance() {
        distanceDriven += this.batteryRemaining > LOW_BATTERY_THRESHOLD ? DISTANCE_PER_DRIVE : 0;
    }

    private void updateBattery() {
        batteryRemaining -= BATTERY_DECAY_PER_DRIVE;
    }
}
