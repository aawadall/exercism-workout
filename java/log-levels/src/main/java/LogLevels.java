public class LogLevels {
    
    /**
     * Returns the message of a log line.
     * @param logLine raw log line
     * @return message of the log line after removing the log level
     */
    public static String message(String logLine) {
        // locate the first column
        int firstColumn = logLine.indexOf(':');

        // return the substring after the first column, with L/R Trim
        return logLine.substring(firstColumn + 1).trim();
    }

    /**
     * Returns the log level of a log line.
     * @param logLine raw log line
     * @return log level of the log line
     */
    public static String logLevel(String logLine) {
        // locate first [
        int firstOpeningBracket = logLine.indexOf('[');
        // locate first ]
        int firstClosingBracket = logLine.indexOf(']');
        // return the substring between the first [ and first ], with L/R Trim, all lower 
        return logLine.substring(firstOpeningBracket + 1, firstClosingBracket)
                        .trim()
                        .toLowerCase();
    }

    /**
     * Returns the reformatting of a log line.
     * in the format of "MESSAGE (LOGLEVEL)"
     * @param logLine raw log line
     * @return reformatted log line
     */
    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
