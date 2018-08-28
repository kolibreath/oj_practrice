public class RotateImage {
    static class Solution {
        public void rotate(int[][] matrix) {
            if(matrix == null || matrix.length == 0)
                return;
            int n = matrix.length;
            int m[][] = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j< n;j++){
                    m[j][i] = matrix[i][j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][n-j-1] = m[i][j];
                }
            }
        }
    }
}
