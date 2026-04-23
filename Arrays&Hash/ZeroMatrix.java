//Given an MxN matrix, if an element is
//  0, set its entire row and column to 0.

//Patterns: Matrix Traversal , Mark First , Modify Later, State Tracking


public class ZeroMatrix {

    void zeroMatrix(int[][] matrix) {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;

        boolean[] rows = new boolean[rowsCount];
        boolean[] cols = new boolean[colsCount];

        // First pass: mark rows and columns that contain 0
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Second pass: set cells to 0 if row or column is marked
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ZeroMatrix obj = new ZeroMatrix();

        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        System.out.println("Before:");
        obj.printMatrix(matrix);

        obj.zeroMatrix(matrix);

        System.out.println("After:");
        obj.printMatrix(matrix);
    }
}
