import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DnDCharacter {
    private static final int MODIFIER_OFFSET = 10;
    private static final int HIT_POINTS = 10;
    private static final double MODIFIER_DIVISOR = 2.0;
    private static final int DIE_TRIES = 4;
    private static final int DIE_SIDES = 6;
    private static final int TOP_DIE_COUNT = 3;

    private Map<String, Integer> abilities;

    public DnDCharacter() {
        this.abilities = Map.of(
                "strength", ability(rollDice()),
                "dexterity", ability(rollDice()),
                "constitution", ability(rollDice()),
                "intelligence", ability(rollDice()),
                "wisdom", ability(rollDice()),
                "charisma", ability(rollDice()));
    }

    /**
     * Given a list of scores, return the sum of the top 3 scores.
     * @param scores list of scores
     * @return sum of top 3 scores
     */
    int ability(List<Integer> scores) {
        int skips = scores.size() - TOP_DIE_COUNT;
        return scores.stream()
            .sorted() // sort ascending
            .skip(skips) // skip lowest to take top 3
            .mapToInt(Integer::intValue) // convert to int
            .sum(); // sum
    }

    /**
     * Roll 4 6-faces dice and return the results.
     * @return list of dice values
     */
    List<Integer> rollDice() {
        var result = new ArrayList<Integer>();
        for (int die = 0; die < DIE_TRIES; die++) {
            var dieResult = rollOneDie();
            result.add(dieResult);
        }
        return result;
    }

    /**
     * Given an ability score, return the modifier.
     * @param input ability score
     * @return modifier
     */
    int modifier(int input) {
        return (int) Math.floor((input - MODIFIER_OFFSET) / MODIFIER_DIVISOR);
    }

    /**
     * Return the strength ability score.
     * @return strength ability score
     */
    int getStrength() {
        return abilities.get("strength");
    }

    /**
     * Return the dexterity ability score.
     * @return dexterity ability score
     */
    int getDexterity() {
        return abilities.get("dexterity");
    }

    /**
     * Return the constitution ability score.
     * @return constitution ability score
     */
    int getConstitution() {
        return abilities.get("constitution");
    }

    /**
     * Return the intelligence ability score.
     * @return intelligence ability score
     */
    int getIntelligence() {
        return abilities.get("intelligence");
    }

    /**
     * Return the wisdom ability score.
     * @return wisdom ability score
     */
    int getWisdom() {
        return abilities.get("wisdom");
    }

    /**
     * Return the charisma ability score.
     * @return charisma ability score
     */
    int getCharisma() {
        return abilities.get("charisma");
    }

    /**
     * Return the hit points.
     * @return hit points
     */
    int getModifierOffset() {
        return modifier(abilities.get("constitution")) + HIT_POINTS;
    }

    /**
     * Roll a single 6-faces die.
     * A helper method for rollDice().
     * @return die value (1-6)
     */
    private int rollOneDie() {
        return (int) (Math.random() * DIE_SIDES) + 1;
    }
}
