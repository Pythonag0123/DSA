class MyQueue {
    Stack<Integer> st;
    Stack<Integer> s;

    public MyQueue() {
        st = new Stack<>();
        s = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
        
    }
    
    public int pop() {
        if(st.isEmpty() && s.isEmpty()) return -1;
        if(s.isEmpty()){
            while(!st.isEmpty()){
                s.push(st.pop());
            }
        }
        return s.pop();
        
    }
    
    public int peek() {
        if (st.isEmpty() && s.isEmpty()) return -1;

        if (s.isEmpty()) {
            while (!st.isEmpty()) {
                s.push(st.pop());
            }
        }
        return s.peek();
    }
    
    public boolean empty() {
        return s.isEmpty() && st.isEmpty();

        
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