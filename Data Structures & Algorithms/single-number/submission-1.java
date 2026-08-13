class Solution {
    public int singleNumber(int[] nums) {
        //same : use xor
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
