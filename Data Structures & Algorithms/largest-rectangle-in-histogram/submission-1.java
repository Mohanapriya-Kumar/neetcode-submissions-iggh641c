class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxA = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxA = Math.max(maxA, height*width);
            }
            stack.push(i);
        }
        
        //if only push happens (if ip is in increasinig order) pop using below
        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxA = Math.max(maxA, h*w);
        }    
        return maxA;
    }
}
