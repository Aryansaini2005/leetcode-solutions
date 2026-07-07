class StockSpanner {
    ArrayList<Integer> list;
    Stack<Integer> st;
    public StockSpanner() {
        list = new ArrayList<>();
        st = new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);
        int idx = list.size()-1;
        int span = 0;
        while(!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
        }
        if(st.isEmpty()) {
            span = -1;
        }else {
            span = st.peek();
        }
        st.add(idx);
        return idx-span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */