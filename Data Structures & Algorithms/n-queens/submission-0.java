class Solution {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] r : board){
            Arrays.fill(r, '.');
        }
        backtrack(0,n,board);
        return res;
    }

    private void backtrack(int row, int n, char[][] board){
        if(row == n){
            List<String> curr = new ArrayList<>();
            for(char[] r : board){
                curr.add(new String(r));
            }
            res.add(curr);
        }

        for(int col = 0; col < n; col++){
            if(cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) continue;
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            board[row][col] = 'Q';

            backtrack(row+1, n, board);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}
