class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return sumSubArrayMaxs(nums,n) - sumSubArrayMins(nums,n); 
    }
    public long sumSubArrayMins(int[] nums, int n) {
        int[] nse = new int[n];
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty()? n:st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) {
            st.pop();
        }

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty()? -1:st.peek();
            st.push(i);
        }

        long total = 0;
        for(int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            total += left*right*nums[i];
        }
        return total;
    }
    public long sumSubArrayMaxs(int[] nums, int n) {
        int[] nge = new int[n];
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty()? n:st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) {
            st.pop();
        }

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty()? -1:st.peek();
            st.push(i);
        }

        long total = 0;
        for(int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            total += left*right*nums[i];
        }
        return total;
    }
}