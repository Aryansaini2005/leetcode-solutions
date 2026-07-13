class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i < n && intervals[i][0] <= end) {
                end = Math.max(end,intervals[i][1]);
                i++;
            }
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(start);
            pair.add(end);
            ans.add(pair);
        }
        int row = ans.size();
        int[][] res = new int[row][2];
        for(int j = 0; j < row; j++) {
            for(int k = 0; k < 2; k++) {
                res[j][k] = ans.get(j).get(k);
            }
        }
        return res;
    }
}