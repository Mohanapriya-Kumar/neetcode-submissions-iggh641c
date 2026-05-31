class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<Integer> st = new Stack<>(); //Monotonic decreasing stores idx
        for(int i = 0; i < temps.length; i++){
            while(!st.isEmpty() && temps[i] > temps[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx; //wait for these many days
            }
            st.push(i);
        }
        return res;
    }
}
