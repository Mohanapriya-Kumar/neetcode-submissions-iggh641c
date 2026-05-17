class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] box = new int[9];
        int[] row = new int[9];
        int[] col = new int[9];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;
                int key = board[r][c] - '1';
                int mask = 1 << key;
                int b = r/3 * 3 + c/3;
                if(((box[b] & mask) != 0) || ((row[r] & mask) != 0) || ((col[c] & mask) != 0)) return false;
                box[b] |= mask;
                row[r] |= mask;
                col[c] |= mask; 
            }
        }
        return true;
    }
}
