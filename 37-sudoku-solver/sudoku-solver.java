class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isPossible(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false; // if no valid number works here
                }
            }
        }
        return true; // solved successfully
    }

    private boolean isPossible(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // check row
            if (board[i][col] == c) return false; // check col
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; // check 3x3 grid
        }
        return true;
    }
}