class Solution {
    public int subtractProductAndSum(int n) {
        int temp = Math.abs(n);
        int sum = 0;
        int product = 1;
        while(temp > 0) {
            int digit = temp%10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return product-sum;
    }
}