class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //at dp[i] we say till prev index(i-1) word break is possible
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; //"" substring can be formed -> true
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; //once true need to check more substrings so far till i just go i++
                }
            }
        }
        return dp[n];
    }
}
