public class Twofer {
    /**
     * Returns a string with the name to print in the twofer string.
     * @param name the name to print
     * @return toger string
     */
    public String twofer(String name) {
        var nameToPrint = getNameToPrint(name);
        return String.format("One for %s, one for me.", nameToPrint);
    }

    /**
     * Returns the name to print in the twofer string.
     * @param name input name 
     * @return name to print
     */
    private String getNameToPrint(String name) {
        return name == null ? "you" : name;
    }
}
