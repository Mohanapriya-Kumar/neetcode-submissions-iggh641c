class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int c : cost){
            int t = c + Math.min(a, b);
            a = b;
            b = t;
        }
        return Math.min(a,b);
    }
}
