class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!st.isEmpty() && (ch == 'B' && st.peek() == 'A')) {
                st.pop();
            }
            else if(!st.isEmpty() && (ch == 'D' && st.peek() == 'C')) {
                st.pop();
            }
            else {
                st.add(ch);
            }
        }

        return st.size();
    }
}