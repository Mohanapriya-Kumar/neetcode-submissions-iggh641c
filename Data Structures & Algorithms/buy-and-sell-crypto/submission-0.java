class Solution {
    public int maxProfit(int[] prices) {
        //in left you buy for less and in right you sell for more
        int l = 0, r = 1; //a lil different but fun
        //min wait for the next price to get profit.. you don't buy and sell for the same price
        int maxP = 0;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l]; //sold - bought
                maxP = Math.max(maxP, profit);
            } else { //meaning r might have a lower price so buy there
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
