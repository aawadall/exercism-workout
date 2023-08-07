
public class Hamming {
    private String leftStrand;
    private String rightStrand;

    /**
     * Constructor for the Hamming distance class.
     * 
     * @param leftStrand  Left DNA strand
     * @param rightStrand Right DNA strand
     * @throws IllegalArgumentException if either strand is empty or if the strands
     *                                  are of unequal length.
     */
    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        validateInput();
    }

    /**
     * Returns the hamming distance between the two strands.
     * This method will never be called for strands of unequal length.
     * 
     * @return the hamming distance between the two strands passed to the
     *         constructor
     */
    public int getHammingDistance() {

        // short circuit if empty strands are equal
        if (leftStrand.isEmpty()) {
            return 0;
        }

        // count differences
        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            count += leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0;
        }
        
        return count;
    }

    // Helper methods

    /**
     * Validates the input to the constructor.
     * 
     * @throws IllegalArgumentException
     */
    private void validateInput() throws IllegalArgumentException {
        if (this.leftStrand.length() != this.rightStrand.length()) {
            if (this.leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (this.rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

}
