import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * Captures 1G seconds since date
 */
public class Gigasecond {
    // internal representation of seconds since epoch
    private final long seconds;

    // Magic numbers
    private static final long OFFSET = 1000000000;
    private static final long MILLIS_IN_SECOND = 1000;

    /**
     * Instantiates a container of 1G seconds since provided date 
     * using start of day for the time component
     * @param moment LocalDate of date to start counting from
     */
    public Gigasecond(LocalDate moment) {
        this.seconds = translateFromDate(moment);
    }

    /**
     * Instantiates a container of 1G seconds since provided date
     * @param moment LocalDateTime of date to start counting from
     */
    public Gigasecond(LocalDateTime moment) {
        this.seconds = translateFromDate(moment);
    }

    /**
     * Get date time value of the gigasecond since provided date
     * @return LocalDateTime of gigasecond since provided date
     */
    public LocalDateTime getDateTime() {
        return translateFromSeconds(seconds);
    }

    // helper methods 

    /**
     * Translate from LocalDate to seconds since epoch
     * @param moment LocalDate
     * @return seconds since epoch
     */
    private static long translateFromDate(LocalDate moment) {
        // convert to datetime 
        LocalDateTime momentDateTime = moment.atStartOfDay();
        // convert to milliseconds
        return translateFromDate(momentDateTime);
    }
     
    /**
     * Translate from LocalDateTime to seconds since epoch
     * @param moment LocalDateTime
     * @return seconds since epoch
     */
    private static long translateFromDate(LocalDateTime moment) {
        long milliseconds = moment.toInstant(ZoneOffset.UTC).toEpochMilli();
        // convert to seconds
        return  OFFSET + millisToSeconds(milliseconds);
    }

    /**
     * Translate from seconds since epoch to LocalDateTime
     * @param seconds seconds since epoch
     * @return LocalDateTime
     */
    private static LocalDateTime translateFromSeconds(long seconds) {
        // convert to milliseconds
        long milliseconds = secondsToMillis(seconds);
        // convert milliseconds to time difference from epoch
        var moment = java.time.Instant.ofEpochMilli(milliseconds);

        // return instant + epoch offset
        return LocalDateTime.ofInstant(moment, ZoneOffset.UTC);
    }

    private static long millisToSeconds(long milliseconds) {
        return milliseconds / MILLIS_IN_SECOND;
    }

    private static long secondsToMillis(long seconds) {
        return seconds * MILLIS_IN_SECOND;
    }
}
