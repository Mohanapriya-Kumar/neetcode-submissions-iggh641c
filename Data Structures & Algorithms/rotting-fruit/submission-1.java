class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int mins = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 2) q.offer(new int[]{r,c});
                else if(grid[r][c] == 1) fresh++; 
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int n = q.size();
            for(int i = 0; i < n; i++){
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];
                for(int d[] : dirs){
                    int x_ = x + d[0];
                    int y_ = y + d[1];
                    if(x_ < 0 || x_ >= grid.length || y_ < 0 || y_ >= grid[0].length) continue;
                    if(grid[x_][y_] != 1) continue;
                    grid[x_][y_] = 2;
                    fresh--;
                    q.offer(new int[]{x_,y_});
                }
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}
