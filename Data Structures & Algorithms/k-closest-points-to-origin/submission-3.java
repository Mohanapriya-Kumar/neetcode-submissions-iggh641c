class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //pq is min Heap by default: if we want k smallest we take away larger..
        //if we want k largest we remove small
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]) 
        );
        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        int idx = 0;
        for(int[] p : pq){
            res[idx++] = p;
        }
        return res;
    }
}
