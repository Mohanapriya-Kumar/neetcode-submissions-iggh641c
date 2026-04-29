class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxPrice = 0;
        for(int p : prices){
            if(p < minPrice) minPrice = p; //if you find a better day to buy then I buy there
            maxPrice = Math.max(p - minPrice, maxPrice); // if frwd is larger sell
        }
        return maxPrice;
    }
}
