class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        //123456
        int count = 1, maxC = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1) count++;
            if(nums[i] != nums[i-1]+1) count = 1;
            maxC = Math.max(maxC, count);
        }
        return maxC;
    }
}
