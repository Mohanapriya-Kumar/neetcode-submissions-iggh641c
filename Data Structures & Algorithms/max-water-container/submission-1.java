class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int h = Math.min(heights[l], heights[r]);
            int w = r - l;
            int area = w*h;
            maxArea = Math.max(maxArea, area);
            if(l < r && heights[l] < heights[r]) l++; 
            else r--;
        }
        return maxArea;
    }
}
