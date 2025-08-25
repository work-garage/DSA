class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; 
                            if (solve(board)) return true; 
                            board[row][col] = '.';
                        }
                    }
                   
                    return false;
                }
            }
        }
       
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {

            if (board[i][col] == c) return false;

            if (board[row][i] == c) return false;

            int r = boxRowStart + i / 3;
            int cc = boxColStart + i % 3;
            if (board[r][cc] == c) return false;
        }
        return true;
    }
}
