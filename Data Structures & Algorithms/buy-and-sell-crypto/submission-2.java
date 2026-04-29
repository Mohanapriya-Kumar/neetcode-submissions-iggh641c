class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxPrice = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i]; //if you find a better day to buy then I buy there
            maxPrice = Math.max(prices[i] - minPrice, maxPrice); // if frwd is larger sell
        }
        return maxPrice;
    }
}
