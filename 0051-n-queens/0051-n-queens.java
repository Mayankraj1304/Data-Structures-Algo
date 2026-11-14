import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // Main diagonals (row - col)
        boolean[] diag2 = new boolean[2 * n - 1]; // Anti-diagonals (row + col)
        
        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1; // Normalized index for main diagonal
            int d2 = row + col;         // Index for anti-diagonal
            
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue; // Queen can't be placed here
            }
            
            // Place the queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            
            // Move to the next row
            backtrack(row + 1, n, board, cols, diag1, diag2, result);
            
            // Backtrack (remove the queen)
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
