public class ToeplitzMatrix {
    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            if(matrix.length == 1)
                return true;
            int index = matrix[0][0];
            int i = 1;
            for(i = 1;i<matrix.length&&i<matrix[0].length;i++){
                if(index != matrix[i][i])
                    return false;
            }
            return true;
        }
    }
}
