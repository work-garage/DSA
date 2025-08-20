class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;

        int result = 0;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(t[i], -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    result += solve(i, j, matrix, t);
                }
            }
        }

        return result;
    }

    int m, n;

    int solve(int i, int j, int[][] matrix, int[][] t) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (matrix[i][j] == 0) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int right = solve(i, j + 1, matrix, t);
        int diag  = solve(i + 1, j + 1, matrix, t);
        int below = solve(i + 1, j, matrix, t);

        t[i][j] = 1 + Math.min(right, Math.min(diag, below));
        return t[i][j];
    }

}