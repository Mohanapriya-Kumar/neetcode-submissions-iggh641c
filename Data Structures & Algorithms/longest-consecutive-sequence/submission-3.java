class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int c = 1, maxc = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == nums[i - 1] + 1) c++;
            if(nums[i] != nums[i - 1] + 1) c = 1;
            maxc = Math.max(c, maxc);
        }
        return maxc;
    }
}
