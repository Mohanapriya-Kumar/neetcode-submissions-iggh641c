class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (l < r && sum < target) l++;
            else if (l < r && sum > target) r--;
            else return new int[] {l+1, r+1};
        }
        return new int[] {};
    }
}
