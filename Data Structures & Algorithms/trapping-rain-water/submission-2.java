class Solution {
    public int trap(int[] h) {
        int res = 0;
        int l = 0, r = h.length - 1; 
        int leftMax = h[l], rightMax = h[r];
        while(l < r) {
            if(l < r && h[l] < h[r]) {
                l++;
                leftMax = Math.max(leftMax, h[l]);
                res += leftMax - h[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, h[r]);
                res += rightMax - h[r];
            }
        }
        return res;
    }
}
