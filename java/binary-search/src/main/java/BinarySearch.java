import java.util.Arrays;
import java.util.List;

class BinarySearch {
    private int[] ints;

    public BinarySearch(int[] ints) {
        this.ints = ints;
    }

    public BinarySearch(List<Integer> ints) {
        this.ints = ints.stream().mapToInt(i -> i).toArray();
    }

    int indexOf(int i) throws ValueNotFoundException{
        return search(i, ints);
    }

    int search(int a, int[] arr) throws ValueNotFoundException {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        return (int) genericSearch(a, boxedArr);
        
    }

    int search(float a, float[] arr) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int search(double a, double[] arr) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int search(long a, long[] arr) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    /**
     * Generic binary search
     * 
     * @param a   value to search
     * @param arr sorted array to search in
     * @param <T> type of array
     * @return index of value in array
     */
    private static <T extends Comparable<T>> int genericSearch(T a, T[] arr) throws ValueNotFoundException{
        // Short circuit if array is empty
        if (arr.length == 0) {
            throw new ValueNotFoundException("Value not in array");
        }
        
        // Normal operation
        var found = false;
        var leftIndex = 0;
        var rightIndex = arr.length - 1;

        while (!found) {
            // slice array in half
            var middleIndex = (leftIndex + rightIndex) / 2;
            var middleValue = arr[middleIndex];

            // check if left and right index have crossed
            if (leftIndex > rightIndex) {
                break;
            }

            // check if middle value is equal to a
            if (middleValue.compareTo(a) == 0) {
                return middleIndex;
            }

            // check if middle value is less than a
            if (middleValue.compareTo(a) < 0) {
                leftIndex = middleIndex + 1;
            }

            // check if middle value is greater than a
            if (middleValue.compareTo(a) > 0) {
                rightIndex = middleIndex - 1;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }
}
