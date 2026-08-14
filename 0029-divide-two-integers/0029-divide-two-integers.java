class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ans = 0;

        // Try powers of 2 from large to small
        for (int i = 31; i >= 0; i--) {

            if ((a >> i) >= b) {
                ans += (1L << i);
                a -= (b << i);
            }
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            ans = -ans;
        }

        return (int) ans;
    }
}