class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //reverse Order is very important
        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){// there is a pair
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first != second){
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    
    }
}
