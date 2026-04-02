class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, in = 0;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>(); //to store indices
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1){ //outside current window remove from front
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){ //allow only decreasing order.. if someone is smaller in dq remove 
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i-k+1 >= 0){
                res[in++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
