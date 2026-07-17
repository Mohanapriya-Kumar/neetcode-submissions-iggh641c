class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for(int n : nums){
            int t = Math.max(a + n, b);
            a = b;
            b = t;
        }
        return Math.max(a,b);
    }
}
