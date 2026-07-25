class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0; //num of coins needed to form amt 0
        for(int a = 1; a <= amount; a++){
            dp[a] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= a && dp[a - coin] != Integer.MAX_VALUE) dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
