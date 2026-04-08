class MedianFinder {
    PriorityQueue<Integer> small; //smaller left half - use maxHeap to retrive the inner most
    PriorityQueue<Integer> large; //larger right half - minHeap
   
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num); //basically you'll start from left
        if(!large.isEmpty() && small.peek() > large.peek()){//if the number I just added is greater but is in the left
            large.offer(small.poll());
        }

        if(small.size() > large.size() + 1){
            large.offer(small.poll());
        }

        if(large.size() > small.size() + 1){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() > large.size()) return small.peek();
        else if(large.size() > small.size()) return large.peek();
        else return (small.peek() + large.peek())/2.0;
    }
}
