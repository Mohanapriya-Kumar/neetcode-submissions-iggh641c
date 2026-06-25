class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < prevEnd){
                count++;
            } else {
                prevEnd = curr[1];
            }
        }
        return count;
    }
}
