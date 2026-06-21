class Solution {

    //easy: it is a circle so choose range: skip last (1st to last prev ele) or skip first and go til last
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
    }
    private int robHelper(int[] nums, int start, int end){
        int a = 0, b = 0;
        for(int i = start; i <= end; i++){
            int temp = Math.max(nums[i] + a, b);
            a = b;
            b = temp;
        }
        return b;
    }
}
