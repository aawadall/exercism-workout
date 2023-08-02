import java.util.Map;

class RaindropConverter {

    private static final Map<Integer, String> FACTOR_TO_SOUND = Map.of(
        3, "Pling",
        5, "Plang",
        7, "Plong"
    );

    String convert(int number) {
        var sound = new StringBuilder();

        FACTOR_TO_SOUND.keySet().stream()
            .sorted()
            .filter(factor -> number % factor == 0) // filter out factors
            .forEach(factor -> sound // build sound
                    .append(FACTOR_TO_SOUND.get(factor)));
        
        return sound.length() == 0 ? 
            String.valueOf(number) : 
            sound.toString();
    }

}
