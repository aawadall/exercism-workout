import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

class Scrabble {

    // Map of characters and their scores.
    // proposed: Migrate to a configuration file
    private static final Map<Character, Integer> characterScore = Map.ofEntries(        
            new SimpleEntry<Character, Integer>('A', 1),
            new SimpleEntry<Character, Integer>('E', 1),
            new SimpleEntry<Character, Integer>('I', 1),
            new SimpleEntry<Character, Integer>('O', 1),
            new SimpleEntry<Character, Integer>('U', 1),
            new SimpleEntry<Character, Integer>('L', 1),
            new SimpleEntry<Character, Integer>('N', 1),
            new SimpleEntry<Character, Integer>('R', 1),
            new SimpleEntry<Character, Integer>('S', 1),
            new SimpleEntry<Character, Integer>('T', 1),
            new SimpleEntry<Character, Integer>('D', 2),
            new SimpleEntry<Character, Integer>('G', 2),
            new SimpleEntry<Character, Integer>('B', 3),
            new SimpleEntry<Character, Integer>('C', 3),
            new SimpleEntry<Character, Integer>('M', 3),
            new SimpleEntry<Character, Integer>('P', 3),
            new SimpleEntry<Character, Integer>('F', 4),
            new SimpleEntry<Character, Integer>('H', 4),
            new SimpleEntry<Character, Integer>('V', 4),
            new SimpleEntry<Character, Integer>('W', 4),
            new SimpleEntry<Character, Integer>('Y', 4),
            new SimpleEntry<Character, Integer>('K', 5),
            new SimpleEntry<Character, Integer>('J', 8),
            new SimpleEntry<Character, Integer>('X', 8),
            new SimpleEntry<Character, Integer>('Q', 10),
            new SimpleEntry<Character, Integer>('Z', 10)
    );

    private String word;
    private int score = 0;
    private Boolean wordChanged = true;
    
    Scrabble(String word) {
        // Words collapsed to uppercase to simplify the logic.
        this.word = word.toUpperCase();
        getScore();
    }

    /**
     * Memoized score getter.
     * @return score for the word
     */
    int getScore() {
        if (!wordChanged) {
            return this.score;
        }

        this.score = this.word.chars()
            .map(c -> characterValue(c))
            .sum();

        this.wordChanged = false;
        return this.score;
    }

    /**
     * Returns character score based on the map.
     * @param c character to get score for
     * @return score for the character
     */
    private Integer characterValue(int c) {
        return characterScore.getOrDefault((char) c, 0);
    }

}
