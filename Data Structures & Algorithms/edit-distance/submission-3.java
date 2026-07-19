class Solution {
    public int minDistance(String s1, String s2) {
        s1 = "#" + s1;
        s2 = "#" + s2;
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];

        for(int i = 1; i < n; i++) dp[i][0] = i;
        for(int j = 1; j < m; j++) dp[0][j] = j;

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i-1][j-1];
                else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int update = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, update));
                }
            }
        }
        return dp[n-1][m-1];
    }
}
