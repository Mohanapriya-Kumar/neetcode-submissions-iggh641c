class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(true){ //there is definitely cycle so dw no forever loop
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(fast == slow) return slow;
        }
    }
}
