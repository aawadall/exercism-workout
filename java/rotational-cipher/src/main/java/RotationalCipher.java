import java.util.HashMap;
import java.util.Map;

class RotationalCipher {
    private int shiftKey;
    private static final int ALPHABET_SIZE = 26;
    private static final int ASCII_UPPERCASE_START = 65;
    private static final int ASCII_UPPERCASE_END = 90;
    private static final int ASCII_LOWERCASE_START = 97;
    private static final int ASCII_LOWERCASE_END = 122;

    private Map<Character, Character> encryptionMap;
    /**
     * Instantiates a new Rotational cipher.
     * @param shiftKey the shift key
     */
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
        this.encryptionMap = new HashMap<>();
    }

    /**
     * Rotatate clear text
     * @param data string to rotate
     * @return rotated string
     */
    String rotate(String data) {
        StringBuilder encryptedData = new StringBuilder();
        for(char c : data.toCharArray()) {
            encryptedData.append(encrypt(c));
        }

        return encryptedData.toString();
    }

    // Helper methods

    /**
     * Encrypts a single character with memoization
     * @param c character to encrypt
     * @return encrypted character
     */
    private char encrypt(char c) {
        // lookup in memoization map
        if(encryptionMap.containsKey(c)) {
            return encryptionMap.get(c);
        }

        // if not found, calculate, save and return
        char encryptedChar = encrypt(c, shiftKey);
        encryptionMap.put(c, encryptedChar);
        return encryptedChar;
    }

    /**
     * Encrypts a single character with a given shift key
     * @param c character to encrypt
     * @param shiftKey shift key
     * @return encrypted character
     */
    private static char encrypt(char c, int shiftKey) {
        int distanceFromStart;

        // wrapping around the alphabet using character offset in alphabet space
        // in case of special characters, return the same character
        if (c >= ASCII_UPPERCASE_START && c <= ASCII_UPPERCASE_END) {
            distanceFromStart = c - ASCII_UPPERCASE_START;
            return (char) (ASCII_UPPERCASE_START + (distanceFromStart + shiftKey) % ALPHABET_SIZE);
        } else if (c >= ASCII_LOWERCASE_START && c <= ASCII_LOWERCASE_END) {
            distanceFromStart = c - ASCII_LOWERCASE_START;
            return (char) (ASCII_LOWERCASE_START + (distanceFromStart + shiftKey) % ALPHABET_SIZE);
        } else {
            return c;
        }
        
    }

}
