import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Matrix {
    private final List<List<Integer>> values;
    private final int rows;
    private final int cols;

    Matrix(List<List<Integer>> values) {
        this.values = values;
        this.rows = values.size();
        this.cols = values.get(0).size(); // assume all rows have the same number of columns
    }

    /**
     * A saddle point is a matrix element where:
     *  - it is the maximum in its row
     *  - it is the minimum in a column
     * @return the coordinates of all the saddle points of the matrix
     */
    Set<MatrixCoordinate> getSaddlePoints() {
        // iterate over rows to find candidate saddle points
        var candidates = new HashSet<int[]>();
        for (int rowIndex = 0; rowIndex < this.rows; rowIndex++) {
            var rowUnderTest = this.values.get(rowIndex);
            var maxInRow = rowUnderTest.stream().max(Integer::compareTo).orElseThrow();
            var colIndex = rowUnderTest.indexOf(maxInRow);
            candidates.add(
                new int[] { rowIndex , colIndex  } // +1 because the exercise uses 1-based indexing
            );
        }

        // iterate over candidates to find saddle points
        return filterCandidates(candidates);
    }

    private Set<MatrixCoordinate> filterCandidates(Set<int[]> candidate) {
        // for each candidate, check if it is the minimum in its column
        var saddlePoints = new HashSet<MatrixCoordinate>();
        for (var candidateCoordinate : candidate) {
            var column = getColumn(candidateCoordinate[1]);
            var minInColumn = column.stream().min(Integer::compareTo).orElseThrow();
            if (minInColumn == getValue(candidateCoordinate)) {
                saddlePoints.add(new MatrixCoordinate(candidateCoordinate[0]+1, candidateCoordinate[1]+1));
            }
        }
        return saddlePoints;
    }

    private List<Integer> getColumn(int columnIndex) {
        var column = new ArrayList<Integer>();
        for (var row : this.values) {
            column.add(row.get(columnIndex));
        }
        return column;
    }

    private int getValue(int[] coordinate) {
        return this.values.get(coordinate[0]).get(coordinate[1]);
    }
}
