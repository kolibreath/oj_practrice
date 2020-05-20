public class 旋转图像 {
    //    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
    class Solution {
        public void rotate(int[][] matrix) {
            //从左上角开始轴对称变化
            int n = matrix.length;
            for(int j = 0;j < n;j++ ){
                for (int i = j; i < n; i++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            //将每一列进行颠倒
            for (int [] array: matrix) {
                reverse(array);
            }
        }

        public void reverse(int [] array){
            int left =0, right = array.length - 1;
            while(left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left ++;
                right --;
            }
        }
    }
}
