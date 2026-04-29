class Solution {
    public int maxArea(int[] h) {
        int area = 0, maxArea = 0;
        int l = 0, r = h.length - 1;
        while(l < r){
            int maxH = Math.min(h[l],h[r]);
            int w = r - l;
            area = maxH * w;
            maxArea = Math.max(area, maxArea);
            if(h[l] < h[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
