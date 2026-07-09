class Solution {
    public int largestRectangleArea(int[] h) {
        //our goal is to find the right boundary which we will actually exclude
        int n = h.length, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!st.isEmpty() && (i == n || h[i] <= h[st.peek()])){
                int ht = h[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1; 
                maxArea = Math.max(maxArea, ht*w);
            }
            st.push(i);
        }
        return maxArea;
    }
}
