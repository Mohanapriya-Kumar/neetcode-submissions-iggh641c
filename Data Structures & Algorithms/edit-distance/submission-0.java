class Solution {
    private Integer dp[][];
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() +1][word2.length() +1];
        return dfs(0, 0, word1, word2);
    }
    private int dfs(int i, int j, String s1, String s2){
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;

        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = dfs(i+1, j+1, s1, s2);
        
        int insert = 1 + dfs(i, j +1, s1, s2);
        int delete = 1 + dfs(i+1, j, s1, s2);
        int replace = 1 + dfs(i+1, j+1, s1, s2);

        int ans = Math.min(insert,(Math.min(delete, replace)));
        return dp[i][j] = ans;
    }
}
