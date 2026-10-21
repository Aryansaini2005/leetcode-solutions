class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                open++;
            }else if(ch == ')') {
                if(open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(ch);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = sb.length()-1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if(ch == '(' && open > 0) {
                open--;
                continue;
            }
            ans.append(ch);
        }

        return ans.reverse().toString();


    }
}