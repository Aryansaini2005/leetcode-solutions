class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int unmatch = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                balance++;
            }else {
                if(balance > 0) {
                    balance--;
                }else {
                    unmatch++;
                }
            }
        }

        return (unmatch+1)/2;
    }
}