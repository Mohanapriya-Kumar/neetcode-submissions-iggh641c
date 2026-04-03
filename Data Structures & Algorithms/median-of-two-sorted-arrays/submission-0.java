class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        //very important that num1 < nums2
        if(x > y){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0, r = x;
        while(l <= r) {
            int px = l + (r - l)/2; //0
            int py = (x + y + 1)/2 - px;//1
            int leftMaxX = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int rightMinX = (px == x) ? Integer.MAX_VALUE : nums1[px];
            int leftMaxY = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];
            int rightMinY = (py == y) ? Integer.MAX_VALUE : nums2[py];
            if(leftMaxX <= rightMinY && leftMaxY <= rightMinX) {
                if((x + y) % 2 == 0) {
                    return (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY))/2.0;
                } else {
                    return Math.max(leftMaxX, leftMaxY);
                }
            } else if(leftMaxX > rightMinY) {
                r = px - 1;
            } else {
                l = px + 1;
            }
        }
        return 0.0;
    }
}
