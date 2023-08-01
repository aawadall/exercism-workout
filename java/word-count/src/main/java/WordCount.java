import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordCount {
    private static final Set<Character> SEPARATORS = new HashSet<>(Arrays.asList(' ', ',', ':', '&', '@', '$', '%', '^', '!', '.', ';', '\n', '\t', '\r',  '"', '(', ')', '{', '}', '[', ']'));
    public Map<String, Integer> phrase(String input) {
        List<String> words = splitText(input); 
        
        return words.stream()
            .map(normalize) // Normalize
            .filter(word -> !word.isEmpty()) // Remove empty words
            .collect(java.util.stream.Collectors.groupingBy( 
                java.util.function.Function.identity(), // group by word
                java.util.stream.Collectors.summingInt(e -> 1))); // count occurrences
    }

    /**
     * Splits the text into words, using the {SEPARATORS} set.
     * @param text the text to split
     * @return a list of words
     */
    private List<String> splitText(String text) {
        // naive solution
        // replace all separators with a space
        for(Character separator : SEPARATORS) {
            text = text.replace(separator, ' ');
        }

        // compact spaces into one
        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }
        // split by space
        return Arrays.asList(text.split(" "));
    }

    /**
     * Normalizes a word, removing the quotes if present.
     */
    private java.util.function.Function<String, String> normalize = (word) -> {
        if (word.startsWith("'") && word.endsWith("'")) {
            return word.substring(1, word.length() - 1);
        }
        return word.toLowerCase();
    };
}
