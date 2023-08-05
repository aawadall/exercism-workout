class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{
    private int distanceTravelled = 0;
    private static int DISTANCE_PER_ITERATION = 10;
    private int numberOfVictories = 0;

    public void drive() {
        this.distanceTravelled += DISTANCE_PER_ITERATION;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        // TODO Auto-generated method stub
        var delta = this.getNumberOfVictories() - o.getNumberOfVictories();
        if (delta > 0) {
            return 1;
        }

        if (delta < 0) {
            return -1;
        }

        return 0;
    }
}
