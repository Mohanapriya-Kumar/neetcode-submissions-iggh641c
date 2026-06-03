class Solution {
    public int longestConsecutive(int[] nums) { //should be in sorted order
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int c = 1, maxC = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == nums[i - 1] + 1) c++;
            if(nums[i] != nums[i - 1] + 1) c = 1;
            maxC = Math.max(maxC, c);
        }
        return maxC;
    }
}
