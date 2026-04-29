class Solution { // 6 7 8 1 1 2 3 4 5
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1, maxCount = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1) count++;
            if(nums[i] != nums[i-1]+1) count = 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
