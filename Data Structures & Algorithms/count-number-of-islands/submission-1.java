class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    islands++;
                    dfs(r, c, grid) ; //marks neighbours as 0
                }
            }
        }
        return islands;
    }

    private void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
    }
}
