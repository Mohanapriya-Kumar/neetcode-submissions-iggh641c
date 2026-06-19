class Solution {
    int[][] heights;
        int row;
        int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        row = heights.length;
        col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int r = 0; r < row; r++){
            dfs(r, 0, pacific);
            dfs(r, col - 1, atlantic);
        }

        for(int c = 0; c < col; c++){
            dfs(0, c, pacific);
            dfs(row - 1, c, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(pacific[r][c] && atlantic[r][c]) res.add(Arrays.asList(r,c));
            }
        }
        return res;  
    }
    private void dfs(int r, int c, boolean[][] vis){
        if(vis[r][c]) return;
           vis[r][c] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] d : dirs){
            int nr = d[0] + r;
            int nc = d[1] + c;
            if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
            if(heights[nr][nc] < heights[r][c]) continue;

            dfs(nr, nc, vis);
        }     
    } 
}
