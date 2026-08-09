class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            if(a[1] == b[1]) {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int last = intervals[0][1];
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] >= last) {
                cnt++;
                last = intervals[i][1];
            }
        }
        return n-cnt;
    }
}