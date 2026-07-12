class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        if(!right.isEmpty() && left.peek() > right.peek()) right.offer(left.poll());
        if(left.size() - right.size() > 1) right.offer(left.poll());
        if(right.size() - left.size() > 1) left.offer(right.poll());
    }
    
    public double findMedian() {
        if(left.size() > right.size()) return left.peek();
        if(right.size() > left.size()) return right.peek();
        return (left.peek() + right.peek()) /2.0;
    }
}
