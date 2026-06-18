class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(dfs(r,c,0,board,word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board, String word){
        if(i == word.length()) return true;
        if(r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] != word.charAt(i)) return false;

        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(r-1,c,i+1,board,word) || dfs(r+1,c,i+1,board,word) || dfs(r,c-1,i+1,board,word) || dfs(r,c+1,i+1,board,word);
        board[r][c] = temp;
        return found;
    }
}
