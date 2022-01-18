import java.util.ArrayList;

public class 矩阵置零 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        if (!list1.contains(i)) list1.add(i);
                        if (!list2.contains(j)) list2.add(j);
                    }
                }
            }

            // 设置0
            // 列
            for (int c : list2) {
                for (int i = 0; i < m; i++) {
                    matrix[i][c] = 0;
                }
            }
            // 行
            for (int r : list1) {
                for (int j = 0; j < n; j ++) {
                    matrix[r][j] = 0;
                }
            }
        }

        // 使用数组的方式是否会更快一些？
        public void setZeroes2(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] bm = new boolean[m];
            boolean[] bn = new boolean[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        bm[i] = true;
                        bn[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (bm[i] || bn[j] ) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
