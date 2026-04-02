class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){ //here right can never move further left stop when l == r
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1; //if mid is already >r than nums[r] cannot be candidate for smallest
            } else {
                r = mid;
            }
        }
        return nums[r];
    }
}
