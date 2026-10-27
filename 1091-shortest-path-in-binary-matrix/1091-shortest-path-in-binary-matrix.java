class Solution {
    class Pair {
        int row;
        int col;
        int dis;
        Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        Queue<Pair> q = new LinkedList<>();

        int distance[][] = new int[m][n];
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 1;
        q.add(new Pair(0,0,1));

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dis;

            if(row == m-1 && col == n-1) {
                return dist;
            }

            int delrow[] = {-1,+1,0,0,-1,-1,+1,+1};
            int delcol[] = {0,0,-1,+1,-1,+1,-1,+1};

            for(int i = 0; i<8; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol] == 0 && distance[nrow][ncol] > dist + 1) {
                    distance[nrow][ncol] = dist + 1;
                    q.add(new Pair(nrow,ncol,dist+1));
                }
            }  
        }
        return -1;
    }
}