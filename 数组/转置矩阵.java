public class 转置矩阵 {
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] trans = new int[n][m];
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    trans[j][i] = matrix[i][j];
                }
            }
            return trans;
        }

        public int [][] transpose2(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] trans = new int[n][m];
            for (int i = 0; i < m*n; i++) {
                trans[i%n][i/n] = matrix[i/n][i%n];
            }
            return trans;
        }
    }
}
