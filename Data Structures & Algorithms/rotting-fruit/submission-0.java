class Solution {
    //q has coordinates of what can expand ie rotten
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;

        int fresh = 0;
        for(int x = 0; x < r; x++){
            for(int y = 0; y < c; y++){
                if(grid[x][y] == 2) q.offer(new int[]{x,y});
                if(grid[x][y] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;

        int min = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] d : dirs){
                    int x_ = x + d[0];
                    int y_ = y + d[1];
                    if(x_ < 0 || x_ >= r || y_ < 0 || y_ >= c) continue;
                    if(grid[x_][y_] != 1) continue;
                    
                    grid[x_][y_] = 2;
                    fresh--;
                    q.offer(new int[]{x_,y_});
                }
            }
            min++;
        }
        return fresh == 0 ? min : -1;
    }
}
