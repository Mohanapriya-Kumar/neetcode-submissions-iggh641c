class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int i = 0; i < cost.length; i++){
            int c = cost[i] + Math.min(a,b);
            a = b;
            b = c;
        }
        return Math.min(b,a);
    }
}
