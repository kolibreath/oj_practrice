public class 搜索二维矩阵II {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n - 1;
            while(i < m && j >= 0 ) {
                if (matrix[i][j] > target) j --;
                else if (matrix[i][j] < target) i ++;
                else // 相等情况
                    return true;
            }
            return false;
        }
    }
}
