class Solution {
    public int maxProfit(int[] p) {
        int minP = Integer.MAX_VALUE, maxP = 0;
        for(int i = 0; i < p.length; i++){
            minP = Math.min(minP,p[i]);
            int profit = p[i] - minP;
            maxP = Math.max(maxP, profit);
        }
        return maxP;
    }
}
