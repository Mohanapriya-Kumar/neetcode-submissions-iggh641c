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
    
    public void pop() { //check availability before you pop
        if(!minStack.isEmpty() && minStack.peek().equals(stack.peek())) minStack.pop();
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
