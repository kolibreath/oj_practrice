import java.util.ArrayList;
import java.util.List;

public class 螺旋数组 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> output = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return output;
            int m = matrix.length;
            int n = matrix[0].length;
            int total = m*n;
            int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};
            int row = 0, column = 0;
            int dirIndex = 0;
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < total; i++) {
                output.add(matrix[row][column]);
                vis[row][column] = true;
                int nextRow = row + dirs[dirIndex][0];
                int nextColumn = column + dirs[dirIndex][1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || vis[nextRow][nextColumn])
                    dirIndex = (dirIndex + 1) % 4;
                row = row + dirs[dirIndex][0];
                column = column + dirs[dirIndex][1];
            }
            return output;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.spiralOrder(matrix);
    }
}
