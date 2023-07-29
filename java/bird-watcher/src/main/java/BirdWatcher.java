import java.util.Arrays;

class BirdWatcher {
    private static final int BUSY_THRESHOLD = 5;
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
        return Arrays.stream(this.birdsPerDay)
        .filter(d -> d == 0)
        .findAny()
        .isPresent();
    }

    public int getCountForFirstDays(int numberOfDays) {
        final int size = Math.min(numberOfDays, this.birdsPerDay.length);
        return Arrays.stream(this.birdsPerDay).limit(size).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(this.birdsPerDay)
        .filter(d -> d >= BUSY_THRESHOLD)
        .count();
    }
}
