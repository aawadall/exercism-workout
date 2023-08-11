
class Matrix {

    // internal representation of a matrix as a 2D array
    private int[][] matrix;
    private int[][] cols;
    private int rows;
    private int columns;

    Matrix(String matrixAsString) {
        this.matrix = parseMatrix(matrixAsString);
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.cols = getCols(matrix, rows, columns);
    }

    int[] getRow(int rowNumber) {
        return this.matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return this.cols[columnNumber - 1];
    }

    // helper methods 

    /**
     * Parses a string representation of a matrix into a 2D array.
     * assuming that the matrix is well-formed
     * @param matrixAsString the string representation of the matrix
     * @return a 2D array representation of the matrix
     */
    private static int[][] parseMatrix(String matrixString) {
        String[] rows = matrixString.split("\n");
        int[][] matrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] row = rows[i].split(" ");
            matrix[i] = new int[row.length];

            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        return matrix;
    }

    /**
     * Returns a 2D array of the columns of a matrix. 
     * a.k.a. the transpose of the matrix
     * assumes that the matrix is well-formed
     * @param matrix the matrix to get the columns of
     * @param rows the number of rows in the matrix
     * @param columns the number of columns in the matrix
     * @return a 2D array of the columns of the matrix
     */
    private static int[][] getCols(int[][] matrix, int rows, int columns) {
        int[][] cols = new int[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                cols[i][j] = matrix[j][i];
            }
        }

        return cols;
    }
}
