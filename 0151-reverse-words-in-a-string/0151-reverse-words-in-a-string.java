class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < n) {
            while(i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i >= n) break;
            // collect the word
            StringBuilder word = new StringBuilder();
            while(i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }
            st.push(word.toString());
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
            if(!st.isEmpty()) {
                ans.append(' ');
            }
        }
    
        return ans.toString();
    }
}