class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;
        while(r < prices.length) {
            if(prices[l] < prices[r]){
                int res = prices[r] - prices[l];
                maxP = Math.max(maxP, res);
            } else {
                l = r;
            } 
            r++;
        }
        return maxP;
    }
}
