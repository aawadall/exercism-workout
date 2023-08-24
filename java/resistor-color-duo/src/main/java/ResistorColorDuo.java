import java.util.Map;

class ResistorColorDuo {
    private static final Map<String, Integer> colorValues = Map.of(
        "black", 0,
        "brown", 1,
        "red", 2,
        "orange", 3,
        "yellow", 4,
        "green", 5,
        "blue", 6,
        "violet", 7,
        "grey", 8,
        "white", 9
    );

    int value(String[] colors) {
        int resistance = 0;
        for(int bandIndex = 0; bandIndex < colors.length && bandIndex < 2; bandIndex++) {
            resistance *= 10;
            resistance += colorValues.get(colors[bandIndex].toLowerCase());
        }
        return resistance;
    }
}
