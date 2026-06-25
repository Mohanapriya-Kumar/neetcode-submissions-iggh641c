class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);

        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];

            if(interval[0] <= curr[1]){
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                curr = interval;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
