class Darts {
    // magic numbers
    // circle radii
    private static final double OUTER_CIRCLE_RADIUS = 10.0;
    private static final double MIDDLE_CIRCLE_RADIUS = 5.0;
    private static final double INNER_CIRCLE_RADIUS = 1.0;

    // scores
    private static final int OUTSIDE_SCORE = 0;
    private static final int OUTER_CIRCLE_SCORE = 1;
    private static final int MIDDLE_CIRCLE_SCORE = 5;
    private static final int INNER_CIRCLE_SCORE = 10;

    /**
     * Calculates the score of a dart thrown at the point (xOfDart, yOfDart)
     * @param xOfDart x coordinate of the dart
     * @param yOfDart y coordinate of the dart
     * @return the score of the dart thrown at the point (xOfDart, yOfDart)
     */
    int score(double xOfDart, double yOfDart) {
        // calculate eucledean distance from origin 
        var distanceFromOrigin = getDistanceFromOrigin(xOfDart, yOfDart);

        // use short circuiting to avoid unnecessary calculations, moving from outside to inside
        if (distanceFromOrigin > OUTER_CIRCLE_RADIUS) {
            return OUTSIDE_SCORE;
        }

        if (distanceFromOrigin > MIDDLE_CIRCLE_RADIUS) {
            return OUTER_CIRCLE_SCORE;
        }

        if (distanceFromOrigin > INNER_CIRCLE_RADIUS) {
            return MIDDLE_CIRCLE_SCORE;
        }

        return INNER_CIRCLE_SCORE;
    }

    // helper functions 
    /**
     * Calculates the distance from the origin to the point (x, y)
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return the distance from the origin to the point (x, y)
     */

     private static double getDistanceFromOrigin(double x, double y) {
         return Math.sqrt(x * x + y * y);
     }
}
