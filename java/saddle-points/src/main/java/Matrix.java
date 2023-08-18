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
        // first pass: find the max in each row
        var firstPass = new HashSet<InnerCoordinates>();
        for(int idx = 0; idx < rowSize; idx++) {
            var row = rows.get(idx);
            var max = row.stream().max(Integer::compare).get();
            // find all the indices of the max value
            List<Integer> indices = row.stream().collect(
                ArrayList::new, 
                (list, value) -> {
                    if(value == max) {
                        list.add(row.indexOf(value));
                    }
                }, 
                ArrayList::addAll
            );

            int finalIdx = idx;
            indices.forEach(colIndex -> firstPass.add(new InnerCoordinates(finalIdx, colIndex)));
            
        }
        // second pass: find the min in each column
        var secondPass = new HashSet<InnerCoordinates>();
        for(int idx = 0; idx < columnSize; idx++) {
            var col = columns.get(idx);
            var min = col.stream().min(Integer::compare).get();
            // find all the indices of the min value
            List<Integer> indices = col.stream().collect(
                ArrayList::new, 
                (list, value) -> {
                    if(value == min) {
                        list.add(col.indexOf(value));
                    }
                }, 
                ArrayList::addAll
            );

            int finalIdx = idx;
            indices.forEach(rowIndex -> secondPass.add(new InnerCoordinates(rowIndex, finalIdx)));
        }
        // if coordinates match, then it is a saddle point
        // return intersection of first and second pass
        var result = new HashSet<MatrixCoordinate>();
        for(var coord : firstPass) {
            if(secondPass.contains(coord)) {
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
