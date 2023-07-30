public class ElonsToyCar {
    private int distanceDriven = 0;
    private int batteryRemaining = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distanceDriven);
    }

    public String batteryDisplay() {
        var display = batteryRemaining > 0 ? String.format("at %d%%", batteryRemaining) : "empty";
        return String.format("Battery %s", display);
    }

    public void drive() {
        updateDistance();
        updateBattery();
    }

    private void updateDistance() {
        distanceDriven += this.batteryRemaining > 0 ? 20 : 0;
    }

    private void updateBattery() {
        batteryRemaining -= 1;
    }
}
