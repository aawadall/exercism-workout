class NeedForSpeed {
    private int _speed;
    private int _batteryDrain;
    private int _distanceDriven = 0;
    private int _battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this._speed = speed;
        this._batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this._battery <= 0;
    }

    public int distanceDriven() {
        return this._distanceDriven;
    }

    public void drive() {
        if (!this.batteryDrained()) {
            this._distanceDriven += this._speed;
            this._battery -= this._batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;
    public RaceTrack(int distance) {
        this.distance = distance;
    }
    public boolean tryFinishTrack(NeedForSpeed car) {
        while( car.distanceDriven() < this.distance && !car.batteryDrained()) {
            car.drive();
        }
        return car.distanceDriven() >= this.distance;
    }
}
