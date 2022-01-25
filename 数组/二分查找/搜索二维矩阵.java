public class 搜索二维矩阵 {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            if (matrix[m-1][n-1] < target) return false;
            int left = -1, right = m*n;
            while(left + 1 != right) {
                int mid = (left + right) >> 1;
                int i = mid / n;
                int j = mid % n;
                if (matrix[i][j] < target) left = mid;
                else right = mid;
            }
            // 最后的结果是right
            return matrix[right/n][right%n] == target;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
//                {1,3,5,7},
//                {10,11,16,20},
//                {23,30,34,60}
                {1,3}
        };
        System.out.println(solution.searchMatrix(matrix, 2));
    }
}
