class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1; 
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(row[j] == 1 || col[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}