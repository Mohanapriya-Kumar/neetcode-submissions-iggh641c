class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;//no. of ways to get amt 0 is 1 -> combination:chose nthg
        for(int coin : coins){
            for(int a = coin; a <= amount; a++){
                dp[a] += dp[a - coin];
            }
        }
        return dp[amount];

    }
}
