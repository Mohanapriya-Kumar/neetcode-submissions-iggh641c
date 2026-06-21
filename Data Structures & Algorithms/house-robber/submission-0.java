class Solution {
    public int rob(int[] nums) {
        // max of either a + curr or b
        int a = 0, b = 0;
        for(int n : nums){
            int temp = Math.max(a + n, b);
            a = b;
            b = temp;
        }
        return b;
    }
}
