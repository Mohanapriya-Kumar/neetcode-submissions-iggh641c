class Solution {
    public boolean canPartition(int[] nums) {
        //assumed target dp[i] = num[j] (num considered) + remainder
        //so considering num, to write dp[i] I need to check for the existence of remr = dp[i-num]
        // assumed t = num + remr -> rmr = t - num
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;
        int target = sum / 2, n = nums.length;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums){
            for(int t = target; t >= num; t--){
                dp[t] = dp[t] || dp[t - num];
            }
        }
        return dp[target];
    }
}
