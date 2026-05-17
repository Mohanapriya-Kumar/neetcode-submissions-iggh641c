class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0, minP = Integer.MAX_VALUE;
        for(int p : prices){
            if(p < minP) minP = p;
            maxP = Math.max(maxP, p - minP);
        }
        return maxP;
        
    }
}
