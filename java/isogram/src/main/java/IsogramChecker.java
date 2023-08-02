import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class IsogramChecker {
    private static final List<String> EXCLUDED_CHARS = Arrays.asList("-", " ");

    boolean isIsogram(String phrase) {
        
        // exclude some characters from the string 
        for (var excludedChar : EXCLUDED_CHARS) {
            phrase = phrase.replace(excludedChar, "");
        }

        phrase = phrase.toLowerCase().trim(); // compact case and remove spaces

        var charMap = phrase.chars() // break string to int stream
                    .mapToObj(c -> (char) c) // convert to char
                    .collect(Collectors.groupingBy( // map to char count
                        Function.identity(),
                        Collectors.counting()));
    
        // if the map has no char with count > 1, then it is an isogram 
        return !charMap
            .keySet()
            .stream()
            .anyMatch(c -> charMap.get(c) > 1); // check if any char has count > 1
    }

}
