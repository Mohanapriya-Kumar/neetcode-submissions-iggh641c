class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0,nums,target,0);
    }
    private int dfs(int i, int[] nums, int target, int sum){
        if(i == nums.length){
            return sum == target ? 1 : 0;
        }

        String key = i + "," + sum;
        if(memo.containsKey(key)) return memo.get(key);

        int add = dfs(i+1, nums, target, sum + nums[i]);
        int sub = dfs(i+1, nums, target, sum - nums[i]);

        memo.put(key, add+sub);
        return memo.get(key);
    }
}
