public class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int distanceTravelled = 0;
    private static int DISTANCE_PER_ITERATION = 20;
    public void drive() {
        this.distanceTravelled += DISTANCE_PER_ITERATION;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}
