class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty()? -1:st.peek();

            st.push(i);
        }

        int temp[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(nge[i] - i < 0) {
                temp[i] = 0;
            }else {
                temp[i] = nge[i] - i;
            }
            
        }
        return temp;
    }
}