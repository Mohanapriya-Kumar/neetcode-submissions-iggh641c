class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow) break; //definite duplicate
        }
        slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) return slow;
        }
    }
}
