package javaMethods.level3;

//Created MatrixOperations for matrix arithmetic, transpose, determinants and inverses
public class MatrixOperations {
    /** @param rows number of rows @param cols number of columns
     * @return random matrix containing integers from 1 through 9 */
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int) (Math.random() * 9) + 1;
        return matrix;
    }

    /** @param a first matrix @param b second matrix
     * @return sum matrix; matrices must have equal dimensions */
    public static int[][] add(int[][] a, int[][] b) {
        if (!sameDimensions(a, b)) throw new IllegalArgumentException("Matrices must have equal dimensions.");
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    /** @param a first matrix @param b second matrix
     * @return difference matrix; matrices must have equal dimensions */
    public static int[][] subtract(int[][] a, int[][] b) {
        if (!sameDimensions(a, b)) throw new IllegalArgumentException("Matrices must have equal dimensions.");
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    /** @param a first matrix @param b second matrix
     * @return matrix product */
    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) throw new IllegalArgumentException("Columns of A must equal rows of B.");
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++) result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    /** @param matrix input matrix
     * @return transpose of the matrix */
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) result[j][i] = matrix[i][j];
        return result;
    }

    /** @param matrix 2x2 matrix
     * @return determinant */
    public static int determinant2x2(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) throw new IllegalArgumentException("Expected 2x2 matrix.");
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    /** @param m 3x3 matrix
     * @return determinant */
    public static int determinant3x3(int[][] m) {
        if (m.length != 3 || m[0].length != 3) throw new IllegalArgumentException("Expected 3x3 matrix.");
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    /** @param matrix 2x2 matrix
     * @return inverse, or throws if determinant is zero */
    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) throw new IllegalArgumentException("Matrix has no inverse because determinant is zero.");
        return new double[][]{
                {matrix[1][1] / (double) det, -matrix[0][1] / (double) det},
                {-matrix[1][0] / (double) det, matrix[0][0] / (double) det}
        };
    }

    /** @param m 3x3 matrix
     * @return inverse, or throws if determinant is zero */
    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) throw new IllegalArgumentException("Matrix has no inverse because determinant is zero.");
        double[][] result = new double[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int[][] minor = new int[2][2];
                int mi = 0;
                for (int i = 0; i < 3; i++) {
                    if (i == row) continue;
                    int mj = 0;
                    for (int j = 0; j < 3; j++) {
                        if (j == col) continue;
                        minor[mi][mj++] = m[i][j];
                    }
                    mi++;
                }
                int cofactor = determinant2x2(minor);
                if ((row + col) % 2 != 0) cofactor = -cofactor;
                // Transpose the cofactor matrix while dividing by determinant
                result[col][row] = cofactor / (double) det;
            }
        }
        return result;
    }

    /** @param matrix matrix to display */
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) System.out.printf("%5d", value);
            System.out.println();
        }
    }

    /** @param matrix matrix to display */
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) System.out.printf("%10.3f", value);
            System.out.println();
        }
    }

    private static boolean sameDimensions(int[][] a, int[][] b) {
        return a.length == b.length && a[0].length == b[0].length;
    }

    public static void main(String[] args) {
        // Create random 3x3 matrices for arithmetic operations
        int[][] a = createRandomMatrix(3, 3);
        int[][] b = createRandomMatrix(3, 3);
        System.out.println("Matrix A:");
        displayMatrix(a);
        System.out.println("Matrix B:");
        displayMatrix(b);
        System.out.println("A + B:");
        displayMatrix(add(a, b));
        System.out.println("A - B:");
        displayMatrix(subtract(a, b));
        System.out.println("A * B:");
        displayMatrix(multiply(a, b));
        System.out.println("Transpose of A:");
        displayMatrix(transpose(a));
        System.out.println("Determinant of A: " + determinant3x3(a));
        try {
            System.out.println("Inverse of A:");
            displayMatrix(inverse3x3(a));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // Demonstrate 2x2 determinant and inverse
        int[][] small = createRandomMatrix(2, 2);
        System.out.println("2x2 matrix:");
        displayMatrix(small);
        System.out.println("2x2 determinant: " + determinant2x2(small));
        try {
            System.out.println("2x2 inverse:");
            displayMatrix(inverse2x2(small));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
