class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                list.add(i);
            }
        }
        int[] ans = new int[s.length()];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < s.length(); j++) {
                ans[j] = Math.min(ans[j],Math.abs(list.get(i)-j));
            }
        }
        return ans;
    }
}