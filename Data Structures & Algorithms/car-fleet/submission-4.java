class Solution {
    public int carFleet(int target, int[] pos, int[] sp) {
        int n = pos.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = pos[i];
            pairs[i][1] = sp[i];
        }
        Arrays.sort(pairs,
            (a,b) -> Integer.compare(b[0], a[0])
        );

        int fleet = 1;
        double prevTime = (double) (target - pairs[0][0])/pairs[0][1];
        for(int i = 1; i < n; i++){
            double currTime = (double) (target - pairs[i][0])/pairs[i][1];
            if(currTime > prevTime){
                fleet++;
                prevTime = currTime;
            }
        }
        return fleet;
    }
}
