import java.util.Map;

class RaindropConverter {

    private static final Map<Integer, String> FACTOR_TO_SOUND = Map.of(
        3, "Pling",
        5, "Plang",
        7, "Plong"
    );

    String convert(int number) {
        var sound = new StringBuilder();

        for (var factor : FACTOR_TO_SOUND.keySet()) {
            if (number % factor == 0) {
                sound.insert( 0,FACTOR_TO_SOUND.get(factor));
            }
        }
        
        return sound.length() == 0 ? String.valueOf(number) : sound.toString();
    }

}
