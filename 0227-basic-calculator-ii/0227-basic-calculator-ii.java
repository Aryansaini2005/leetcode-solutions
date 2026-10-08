class Solution {
    public int calculate(String s) {
        int n = s.length();
        int ans = 0;
        int num = 0;
        char op = '+';
        int last = 0;
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == n-1) {
                if(op == '+') {
                    ans += last;
                    last = num;
                }
                else if(op == '-') {
                    ans += last;
                    last = -num;
                }
                else if(op == '*') {
                    last = last*num;
                }
                else if(op == '/') {
                    last = last/num;
                }
                op = ch;
                num = 0;
            }
            
        }
        return ans + last;
    }
}