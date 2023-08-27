class PigLatinTranslator {
    public String translate(String word) {
        word = rule3(word);
        word = rule4(word);
        word = rule1(word);
        word = rule2(word);
        return word;
    }

    // Rules 
    /**
     * Rule 1
     * If a word begins with a vowel sound, 
     * add an "ay" sound to the end of the word. 
     * Please note that "xr" and "yt" at the beginning of a word make vowel sounds 
     * (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
     * @param word the word to translate
     * @return the translated word
     */
    private static String rule1(String word) {
        var result = new StringBuilder(word);
        // check rule 
        if (rule1Condition(word)) {
            // apply rule 
            result.append("ay");
        }
        
        return result.toString();
    }

    /**
     * Rule 1 condition
     * If a word begins with a vowel sound,
     * sub-rule 1: "xr" and "yt" at the beginning of a word make vowel sounds
     * sub-rule 2: "a", "e", "i", "o", "u", and "y" followed by a consonant sound
     * @param word the word to translate
     * @return true if the word begins with a vowel sound
     */
    private static boolean rule1Condition(String word) {
        // sub-rule 1
        if (word.startsWith("xr") || word.startsWith("yt")) {
            return true;
        }

        // sub-rule 2
        var vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
        for (var vowel : vowels) {
            if (word.toLowerCase().startsWith(String.valueOf(vowel))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Rule 2
     * If a word begins with a consonant sound,
     * move it to the end of the word and then add an "ay" sound to the end of the word.
     * Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster
     * (e.g. "chair" -> "airchay").
     * @param word the word to translate
     * @return the translated word
     */
    private static String rule2(String word) {
        var result = new StringBuilder(word);
        // check rule 
        if (rule2Condition(word)) {
            // apply rule 
            result.append(word.charAt(0));
            result.deleteCharAt(0);
            result.append("ay");
        }
        
        return result.toString();    
    }

    /**
     * Rule 2 condition
     * If a word begins with a consonant sound,
     * @param word the word to translate
     * @return true if the word begins with a consonant sound
     */
    private static boolean rule2Condition(String word) {
        return !rule1Condition(word);
    }

    
    /**
     * Rule 3
     * If a word starts with a consonant sound followed by "qu", 
     * move it to the end of the word, 
     * and then add an "ay" sound to the end of the word 
     * (e.g. "square" -> "aresquay").
     * @param word the word to translate
     * @return the translated word
     */ 
     private static String rule3(String word) {
        var result = new StringBuilder(word);
        // check rule 
        if (rule3Condition(word)) {
            // apply rule 
            result.append(word.charAt(0));
            result.deleteCharAt(0);
            result.append("ay");
        }
        
        return result.toString();
        }

    /**
     * Rule 3 condition
     * If a word starts with a consonant sound followed by "qu",
     * @param word the word to translate
     * @return true if the word starts with a consonant sound followed by "qu"
     */
    private static boolean rule3Condition(String word) {
        return !rule1Condition(word) && word.substring(1).toLowerCase().startsWith("qu");
    }
    
    /**
     * Rule 4
     * If a word contains a "y" after a consonant cluster 
     * or as the second letter in a two letter word 
     * it makes a vowel sound 
     * (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
     * @param word the word to translate
     * @return the translated word
     */
    private static String rule4(String word) {
        var result = new StringBuilder(word);
        // check rule 
        if (rule4Condition(word)) {
            // apply rule 
            result.append(word.charAt(0));
            result.deleteCharAt(0);
            result.append("ay");
        }
        
        return result.toString();
    }

    /**
     * Rule 4 condition
     * If a word contains a "y" after a consonant cluster 
     * or as the second letter in a two letter word
     * @param word the word to translate
     * @return true if the word contains a "y" after a consonant cluster 
     * or as the second letter in a two letter word
     */
    private static boolean rule4Condition(String word) {
        // scan for consonant cluster
        int index = 0;
        var consonantCluster = new StringBuilder();
        for (var i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            index = i;
            if (isVowel(c)) {
                break;
            }
            consonantCluster.append(c);
        }
        // check if index + 1 is y
        if (index + 1 < word.length() && word.charAt(index + 1) == 'y') {
            return true;
        }
        return false;
    }

    /**
     * Check if a character is a vowel
     * @param c the character to check
     * @return true if the character is a vowel
     */
    private static boolean isVowel(char c) {
        var vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
        for (var vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}