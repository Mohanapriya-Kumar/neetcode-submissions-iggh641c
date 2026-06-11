class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        //stack contains the sml idx for reference - it blocks the expansion of area so that acts as the limit for maxArea
        for(int i = 0; i <= n; i++){ // = n for verification if i == n calc maxArea finally
        //bcuz in the calc we exclude curr 'i' (r) and left index so n gets ignored but n-1 is tested
        //concept: r sml idx - l sml idx - 1 (this excludes both r and l idxs)
            while(!stack.isEmpty() && (i == n || (h[stack.peek()]) >= h[i])){
                int height = h[stack.pop()];
                //curr ht is small so whatever was the pvs is actually taller than curr so that is the ht
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                //if no other h is smaller than me then I am the smallest so max h is  I keep expanding on all taller hts
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
