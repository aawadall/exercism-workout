import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Matrix {
    private final List<List<Integer>> rows;
    private final List<List<Integer>> columns;

    Matrix(List<List<Integer>> values) {
        this.rows = values;
        this.columns = transpose(values);
    }

    /**
     * A saddle point is a matrix element where:
     * - it is the maximum in its row
     * - it is the minimum in a column
     * 
     * @return the coordinates of all the saddle points of the matrix
     */
    Set<MatrixCoordinate> getSaddlePoints() {
        // short circuit if matrix is empty
        if(rows.isEmpty()) {
            return new HashSet<>();
        }

        int rowSize = rows.size();
        int columnSize = columns.size();
        // two pass operation; 
        // first pass: find the max in each row, and store all max coordinates in that row 

        var firstPass = new HashSet<InnerCoordinates>();
        for(int idx = 0; idx < rowSize; idx++) {
            var row = rows.get(idx);
            var max = row.stream().max(Integer::compare).get();
        
            for(int col = 0; col < columnSize; col++) {
                if(row.get(col) == max) {
                    firstPass.add(new InnerCoordinates(idx, col));
                }
            }
        }
        // second pass: ensure this coordinate is not larger than others in a column
        var result = new HashSet<MatrixCoordinate>();
        for(var coord : firstPass) {
            var column = columns.get(coord.col());
            var min = column.stream().min(Integer::compare).get();
            if(rows.get(coord.row()).get(coord.col()) == min) {
                result.add(new MatrixCoordinate(coord.row() + 1, coord.col() + 1));
            }
        }
        return result;
    }

    // Helper methods

    /**
     * Transpose a matrix
     * 
     * @param matrix the matrix to transpose
     * @return the transposed matrix
     */
    private static List<List<Integer>> transpose(List<List<Integer>> matrix) {
        // short circuit if matrix is empty
        if(matrix.isEmpty()) {
            return matrix;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        int columnSize = matrix.get(0).size();
        for (int i = 0; i < columnSize; i++) {
            List<Integer> row = new ArrayList<>();
            for (List<Integer> col : matrix) {
                row.add(col.get(i));
            }
            result.add(row);
        }
        return result;
    }

    // inner class to represent coordinates
    private record InnerCoordinates(int row, int col) {};
}
