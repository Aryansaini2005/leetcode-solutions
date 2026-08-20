class Solution {
    public int arrangeCoins(int n) {
        int ans = 0;
        int i = 1;
        while(n > 0) {
            if(i <= n) {
                ans++;
                n -= i;
                i++;
            }else {
                break;
            }
        }
        return ans;
    }
}