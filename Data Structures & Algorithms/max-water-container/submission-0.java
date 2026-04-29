class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, maxArea = 0;
        while(l < r){
            int minh = Math.min(heights[l],heights[r]);
            int w = r - l;
            int area = minh * w;
            maxArea = Math.max(area, maxArea);
            // while(l < r && heights[l] < minh) l++;
            // while(l < r && heights[r] < minh) r--;
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
