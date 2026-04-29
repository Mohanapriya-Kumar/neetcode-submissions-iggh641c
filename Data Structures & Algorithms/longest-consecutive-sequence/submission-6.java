class Solution {
    public int longestConsecutive(int[] nums) { // longest conseq seq => maxc
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1, maxc = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1) count++;
            if(nums[i] != nums[i-1] + 1) count = 1;
            maxc = Math.max(maxc, count);
        }
        return maxc;
    }
}
