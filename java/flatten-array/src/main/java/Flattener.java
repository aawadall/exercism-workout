import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flattener {
    /**
     * Flattens a list of objects
     * @param input the list of objects to flatten, elements could be lists
     * @return the flattened list of objects
     */
    public static List<Object> flatten(List<Object> input) {
        return input.stream()
            .flatMap(el -> el instanceof List ? 
                flatten(castList(el)).stream() :
                Stream.of(el))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    /**
     * Casts an object to a list of objects
     * @param listElement the object to cast into a list
     * @return the list of objects
     */
    @SuppressWarnings("unchecked")
    private static List<Object> castList(Object listElement) {
        return (List<Object>) listElement;
    }
}