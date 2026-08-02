class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(n,0,0,new StringBuilder(), ans);
        return ans;
    }

    private void f(int n, int open, int close, StringBuilder sb, List<String> ans) {
        if(sb.length() == 2*n) {
            ans.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            f(n,open+1,close,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(')');
            f(n,open,close+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}