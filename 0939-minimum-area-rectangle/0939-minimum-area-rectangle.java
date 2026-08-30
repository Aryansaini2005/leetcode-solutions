class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<String> set = new HashSet<>();
        for(int[] point: points) {
            set.add(point[0]+","+point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        int n = points.length;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 || y1 == y2)
                    continue;
                
                if(set.contains(x1+","+y2) &&
                    set.contains(x2+","+y1)) {
                        int area = Math.abs(x1-x2)*Math.abs(y1-y2);
                        minArea = Math.min(minArea,area);
                    }
            }
        }
        return minArea == Integer.MAX_VALUE? 0 : minArea; 
    }
}