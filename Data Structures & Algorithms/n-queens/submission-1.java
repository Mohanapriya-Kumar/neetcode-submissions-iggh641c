class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> d1 = new HashSet<>();
    Set<Integer> d2 = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] r : board){
            Arrays.fill(r, '.');
        }
        backtrack(0, n, board);
        return res;
    }
    private void backtrack(int row, int n, char[][] board){
        if(row == n){
            List<String> curr = new ArrayList<>();
            for(char[] r : board){
                curr.add(new String(r));
            }
            res.add(new ArrayList<>(curr));
        }
        
        for(int col = 0; col < n; col++){
            if(cols.contains(col) || d1.contains(row - col) || d2.contains(row + col)) continue;
            cols.add(col);
            d1.add(row - col);
            d2.add(row + col);
            board[row][col] = 'Q';
            backtrack(row+1, n, board);
            board[row][col] = '.';
            cols.remove(col);
            d1.remove(row - col);
            d2.remove(row + col);
        }
    }
}
