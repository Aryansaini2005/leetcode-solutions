class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int num = 0;
        StringBuilder cur = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num*10 + ch-'0';
            }
            else if(ch == '[') {
                numSt.push(num);
                strSt.push(cur);

                num = 0;
                cur = new StringBuilder();
            }
            else if(ch == ']') {
                int repeat = numSt.pop();
                StringBuilder prev = strSt.pop();

                for(int j = 0; j < repeat; j++) {
                    prev.append(cur);
                }

                cur = prev; 
            }
            else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}