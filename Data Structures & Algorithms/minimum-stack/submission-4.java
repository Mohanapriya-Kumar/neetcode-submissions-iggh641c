class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && stack.peek().equals(minStack.peek())) minStack.pop();
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        return -1;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) return minStack.peek();
        return -1;
    }
}
