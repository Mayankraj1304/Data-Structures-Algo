class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (search(board, word, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int row, int column, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(wordIndex)) {
            return false;
        }
        char originalCharacter = board[row][column];
        board[row][column] = '#';
        boolean found =
            search(board, word, row + 1, column, wordIndex + 1) ||
            search(board, word, row - 1, column, wordIndex + 1) ||
            search(board, word, row, column + 1, wordIndex + 1) ||
            search(board, word, row, column - 1, wordIndex + 1);
        board[row][column] = originalCharacter;
        return found;
    }
}
