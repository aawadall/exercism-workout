class PigLatinTranslator {
    public String translate(String word) {
        word = rule1(word);
        word = rule2(word); 
        return word;
    }

    /**
     * Rule 1: 
     * If a word begins with a vowel sound, 
     * add an "ay" sound to the end of the word. 
     * Please note that "xr" and "yt" at the beginning of a word make vowel sounds 
     * (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
     * @param word the string to transform
     * @return the transformed string
     */
    private static String rule1(String word) {
        if(beginsWithVowel(word))
            return word + "ay";
        return word;
    }

    /**
     * Begins with a vowel sound
     * Check if the string begins with a vowel sound
     * - a, e, i, o, or u
     * - or xr 
     * - or yt
     * @param word the string to check
     * @return true if the string begins with a vowel sound
     */
    private static boolean beginsWithVowel(String word) {
        // check for xr and yt 
        if(word.startsWith("xr") || word.startsWith("yt"))
            return true;

        // check for a, e, i, o, or u
        char firstChar = word.charAt(0);
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';
    }

    /**
     * Rule 2: 
     * If a word begins with a consonant sound, 
     * move it to the end of the word and then add an "ay" sound to the end of the word. 
     * Consonant sounds can be made up of multiple consonants, 
     * a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
     * @param word the string to transform
     * @return the transformed string
     */
    private static String rule2(String word) {
        if (isConsonantCluster(word)) {
            int clusterMarker = getClusterMarker(word);
            return word.substring(clusterMarker) + word.substring(0, clusterMarker) + "ay";
        }
            
        return word;
    }

    /**
     * is Consonant Cluster
     * @param word the string to check
     * @return true if the string begins with a consonant cluster
     */
    private static boolean isConsonantCluster(String word) {
        // scan the string for a vowel
        return getClusterMarker(word) != -1;
    }

    /**
     * is Vowel
     * @param c the character to check
     * @return true if the character is a vowel
     */
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * get Cluster Marker
     * @param word string to inspect
     * @return the index of the first vowel in the string
     */
    private static int getClusterMarker(String word) {
        // scan the string for a vowel
        for (int idx = 0; idx < word.length(); idx++) {
            if (isVowel(word.charAt(idx)))
                return idx;
        }
        return -1;
    }
    
    /**
     * Rule 3: 
     * If a word starts with a consonant sound followed by "qu", 
     * move it to the end of the word, and then add an "ay" sound to the end of the word 
     * (e.g. "square" -> "aresquay").
     * @param word the string to transform
     * @return the transformed string
     */
    private static String rule3(String word) {
        return word;
    }
    /**
     * Rule 4: 
     * If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound 
     * (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
     * @param word the string to transform
     * @return the transformed string
     */
    private static String rule4(String word) {
        return word;
    } 
 
    
}