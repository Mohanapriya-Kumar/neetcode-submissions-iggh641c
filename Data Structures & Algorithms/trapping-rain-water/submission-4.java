class Solution {
    public int trap(int[] ht) {
        int l = 0, r = ht.length - 1;
        int leftMax = ht[l], rightMax = ht[r];
        int res = 0;
        while(l < r){
            if(ht[l] < ht[r]){
                l++;
                leftMax = Math.max(leftMax, ht[l]);
                res += leftMax - ht[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, ht[r]);
                res += rightMax - ht[r];
            }
        }
        return res;
    }
}
