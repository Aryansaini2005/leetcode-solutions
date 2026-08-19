class Solution {
    public int numSub(String s) {
        int ans = 0;
        int ones = 0;
        int mod = 1000000007;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                ones++;
                ans += ones;
                ans %= mod;
            }else {
                ones = 0;
            }
        }
        return ans;
    }
}