class Solution {
    public int maxArea(int[] heights) {
        int maxA = 0, area = 0;
        int l = 0, r = heights.length - 1;
        while(l < r){
            int w = r - l;
            int h = Math.min(heights[l], heights[r]);
            area = h * w;
            maxA = Math.max(maxA, area);
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxA;
    }
}
