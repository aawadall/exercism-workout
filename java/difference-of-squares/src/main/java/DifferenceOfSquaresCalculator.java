import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        var sum = IntStream.rangeClosed(0, input).sum();
        return sum*sum;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(0, input).map(i -> i*i).sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
