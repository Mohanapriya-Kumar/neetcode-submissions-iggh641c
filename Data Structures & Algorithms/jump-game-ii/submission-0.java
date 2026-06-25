class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i +nums[i]);
            if(i == currEnd){ //very important don't see i == nums[i] see if it is equal to currEnd
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }
}
