import java.util.List;
import java.util.Map;
class SqueakyClean {
    Map<Character, String> replacements = Map.of(
        ' ', "_",
        '\0', "CTRL",
        '\r', "CTRL",
        '\u007F', "CTRL"
    );
    /**
     * Clean string
     * 
     * @param identifier string to clean
     * @return cleaned string
     */
    static String clean(String identifier) {
        var result = identifier;
        result = replaceSpaces(result);
        result = replaceControlCharacters(result);
        result = camelKebob(result);
        result = omitNonCharacters(result);
        result = noGreekLowerCase(result);
        return result;
    }

    /**
     * Replace spaces with underscores
     * 
     * @param identifier string to clean
     * @return cleaned string
     */
    private static String replaceSpaces(String identifier) {
        return identifier.replace(' ', '_');
    }

    /**
     * Replace control characters with `CTRL`
     * 
     * @param identifier string to clean
     * @return cleaned string
     */
    private static String replaceControlCharacters(String identifier) {
        List<Character> controlCharacters = List.of('\0', '\r', '\u007F');
        StringBuilder result = new StringBuilder();

        for (var character : identifier.toCharArray()) {
            if (controlCharacters.contains(character)) {
                result.append("CTRL");
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    /**
     * Convert kebab-case to camelCase
     * 
     * @param identifier string to clean
     * @return cleaned string
     */
    private static String camelKebob(String identifier) {
        StringBuilder result = new StringBuilder();
        var capitalizeNext = false;

        for (var character : identifier.toCharArray()) {
            if (character == '-') {
                capitalizeNext = true;
            } else {
                result.append(capitalize(character, capitalizeNext));
                capitalizeNext = false;
            }
        }
        return result.toString();
    }

    /**
     * Capitalize character if `capitalize` is true
     * 
     * @param character  character to capitalize
     * @param capitalize whether to capitalize or not
     * @return capitalized character
     */
    private static char capitalize(char character, boolean capitalize) {
        if (capitalize) {
            return Character.toUpperCase(character);
        } else {
            return character;
        }
    }

    /**
     * Omit non-characters
     * 
     * @param identifier string to clean
     * @return cleaned string
     */
    private static String omitNonCharacters(String identifier) {
        StringBuilder result = new StringBuilder();

        for (var character : identifier.toCharArray()) {
            if (Character.isLetter(character) || 
                Character.isUpperCase(character) ||
                character == '_') {
                result.append(character);
            }
        }

        return result.toString();
    }

    /**
     * Omit lower case greek letters
     * @param identifier string to clean
     * @return cleaned string
     */
    private static String noGreekLowerCase(String identifier) {
        StringBuilder result = new StringBuilder();

        for (var character : identifier.toCharArray()) {
            if (Character.UnicodeBlock.of(character) != Character.UnicodeBlock.GREEK) {
                result.append(character);
            } else if (Character.isUpperCase(character)) {
                result.append(character);
            }
        }

        return result.toString();
    }
}
