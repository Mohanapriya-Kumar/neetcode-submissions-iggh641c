class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && minStack.peek().equals(stack.peek())) minStack.pop(); //first pop minstack
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
