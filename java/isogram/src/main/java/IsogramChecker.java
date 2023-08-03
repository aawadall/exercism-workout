import java.util.Arrays;
import java.util.List;

class IsogramChecker {
    private static final List<Character> EXCLUDED_CHARS = Arrays.asList('-', ' ');

    boolean isIsogram(String phrase) {
        int bloomFilter = 0;

        for(var character : phrase.toLowerCase().toCharArray()) {
            if(!EXCLUDED_CHARS.contains(character)) {
                int bit = 1 << (character - 'a');
                if((bloomFilter & bit) != 0) {
                    return false;
                }
                bloomFilter |= bit;
            }
        }    
        return true;
    }

}
