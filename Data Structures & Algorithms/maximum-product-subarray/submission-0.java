class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
//dont include nums[0] bcuz already used 
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int tempMax = Math.max(num, Math.max(num*maxSoFar, num*minSoFar));
            int tempMin = Math.min(num, Math.min(num*minSoFar, num*maxSoFar));
            maxSoFar = tempMax;
            minSoFar = tempMin;
            res = Math.max(res, maxSoFar);
        }
        return res;
    }
}
