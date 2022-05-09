class MyQueue {
    
    private Stack<Integer> front = new Stack<Integer>();
    
    private Stack<Integer> back = new Stack<Integer>();

    public MyQueue() {
        ;
    }
    
    public void push(int x) {
        if (front.empty()) {
            front.push(x);
        } else {
            while (!back.empty()) {
                front.push(back.pop());
            }
            back.push(x);
            while (front.size() > 1) {
                back.push(front.pop());
            }
        }
    }
    
    public int pop() {
        int top = front.pop();
        if (!back.empty()) {
            front.push(back.pop());
        }
        return top;
    }
    
    public int peek() {
        return front.peek();
    }
    
    public boolean empty() {
        return front.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */