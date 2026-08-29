class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        return f(1,n,used);
    }

    public int f(int pos, int n, boolean[] used) {
        if(pos > n) {
            return 1;
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(!used[i] && (pos%i == 0 || i%pos == 0)) {
                used[i] = true;
                cnt += f(pos+1,n,used);
                used[i] = false;
            }
        }
        return cnt;
    }
}