public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /*
     * Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
     * the nearest hundredth
     */
    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    /*
     * Calculates and returns the y-intercept of the line between (x1, y1) and
     * (x2, y2), rounded to the nearest hundredth
     */
    public double yIntercept() {
        double yIntercept = y1 - (slope() * x1);
        return roundedToHundredth(yIntercept);
    }

    /*
     * Calculates and returns the slope of the line between (x1, y1) and
     * (x2, y2), rounded to the nearest hundredth
     */
    public double slope() {
        double slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    /**
     * Generates the equation of a line based on the slope and y-intercept.
     *
     * @return The equation of the line in the form "y = mx + b", where m is the
     *         slope and b is the y-intercept.
     */
    public String equation() {
        String equation = "y = ";
        if (slope() == 0) {
            return "y = " + roundedToHundredth(yIntercept());
        } else if (slope() < 0) {
            if (slope() == -1) {
                equation += "-x";
            } else {
                if ((y2 - y1) % (x2 - x1) == 0) {
                    equation += String.format("%s", ((y2 - y1) / (x2 - x1))) + "x";
                } else if (x2 - x1 < 0 && y2 - y1 > 0) {
                    equation += String.format("-%s/%s", y2 - y1, Math.abs(x2 - x1)) + "x";
                } else if (y2 - y1 < 0 && x2 - x1 < 0) {
                    equation += String.format("%s/%s", Math.abs(y2 - y1), Math.abs(x2 - x1)) + "x";
                } else {
                    equation += String.format("-%s/%s", Math.abs(y2 - y1), x2 - x1) + "x";
                }
            }
        } else {
            if (slope() == 1) {
                equation += "x";
            } else if (x2 - x1 < 0 && y2 - y1 < 0) {
                equation += String.format("%s/%s", Math.abs(y2 - y1), Math.abs(x2 - x1));
            } else if ((x2 - x1 == y2 - y1) || ((y2 - y1) % (x2 - x1)) == 0) {
                equation += String.format("%s", ((y2 - y1) / (x2 - x1))) + "x";
            } else {
                equation += String.format("%s/%s", y2 - y1, x2 - x1) + "x";
            }
        }

        if (yIntercept() < 0) {
            equation += " - " + Math.abs(roundedToHundredth(yIntercept()));
        } else if (yIntercept() > 0) {
            equation += " + " + yIntercept();
        } else {
            equation += "";
        }

        return equation;
    }

    /**
     * Generates a coordinate in the form (x, y) for a given x value.
     *
     * @param  xValue  the x value for which the coordinate is generated
     * @return         the coordinate in the form (x, y)
     */
    public String coordinateForX(double xValue) {
        String coordinate = "(" + xValue + ", " + roundedToHundredth(slope() * xValue + yIntercept()) + ")";
        return coordinate;
    }

    /**
     * Returns the given number rounded to the nearest hundredth.
     *
     * @param  toRound  the number to be rounded
     * @return          the rounded number
     */
    public double roundedToHundredth(double toRound) {
        double rounded = Math.round(toRound * 100);
        return rounded / 100;
    }

    /**
     * Returns a string containing information about the line.
     *
     * @return          a string with the original points, the equation of the line, the slope,
     *                  the y-intercept, and the distance between the two points
     */
    public String lineInfo() {
        String info = "The original points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line in y = mx + b format: " + equation() + "\n" +
                "The slope of the line: " + slope() + "\n" +
                "The y-intercept of the line: " + yIntercept() + "\n" +
                "The distance between the two points: " + distance();
        return info;
    }

}