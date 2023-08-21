import java.util.HashSet;
import java.util.Set;

public class Robot {
    private String name;
    private static Set<String> usedNames = new HashSet<>();
    public Robot() {
        this.name = generateName();
    }

    /**
     * Returns the name of the robot
     * 
     * @return robot name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the robot to the given string
     * and adds the name to the list of used names
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
        usedNames.add(name);
    }

    /**
     * Resets the name of the robot to a new random name
     * and removes the old name from the list of used names
     */
    public void reset() {
        var oldName = this.name;
        this.name = generateName();
        usedNames.remove(oldName);
    }

    /**
     * Generates a random name for the robot
     * Name should not be the same as any other robot
     * Name should be in the format AA### 
     * where A is a letter and # is a number
     * @return robot name as a string
     */
    private String generateName() {
        var candidateName = "";
        while (usedNames.contains(candidateName) || 
        candidateName == "") {
            candidateName = generateRandomName();
        }

        this.setName(candidateName);
        return candidateName;
    }

    /**
     * Generates a random name for the robot
     * in the format AA###
     * where A is a letter and # is a number
     * @return robot name as a string
     */
    private static String generateRandomName() {
        var name = "";
        for (int i = 0; i < 2; i++) {
            name += (char) (Math.random() * 26 + 'A');
        }
        for (int i = 0; i < 3; i++) {
            name += (int) (Math.random() * 10);
        }
        return name;
    }

}