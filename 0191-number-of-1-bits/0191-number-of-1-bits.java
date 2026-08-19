class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        String binary = decimalToBinary(n);
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
    public String decimalToBinary(int n) {
        StringBuilder ans = new StringBuilder();
        while(n > 0) {
            ans.append(n%2);
            n /= 2;
        }

        return ans.reverse().toString();
    }
}