class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, in = 0;
        int[] res = new int[n-k+1];
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1) dq.pollFirst();
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
            if(i-k+1 >= 0) {
                res[in++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
