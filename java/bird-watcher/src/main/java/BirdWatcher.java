
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay.clone();
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for(int day : this.birdsPerDay) {
            if(day == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        final int size = Math.min(numberOfDays, this.birdsPerDay.length);
        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += this.birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        final int busyThreshold = 5;
        int busyDays = 0;
        for (int day : this.birdsPerDay) {
            busyDays += day >= busyThreshold ? 1 : 0;
        }
        return busyDays;
    }
}
