class Solution {
    // q holds treasure / path to treasure -> Queue of array - array of x and y
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int x = 0; x < r; x++){
            for(int y = 0; y < c; y++){
                if(grid[x][y] == 0) q.offer(new int[]{x,y});
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] d : dirs){
                int x_ = x + d[0];
                int y_ = y + d[1];

                if(x_ < 0 || x_ >= r || y_ < 0 || y_ >= c) continue;
                if(grid[x_][y_] != Integer.MAX_VALUE) continue;
                grid[x_][y_] = grid[x][y] + 1;
                q.offer(new int[]{x_,y_});
            }

        }
    }
}
