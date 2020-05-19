import java.util.Arrays;

public class 旋转数组 {
    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length -1);
            reverse(nums,0, k-1 );
            reverse(nums,k, nums.length-1 );
        }

        //旋转数组的部分内容 实质上就是交换数组两端的内容
        private void reverse(int num[], int start, int end){
            while(start < end){
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                start ++;
                end --;
            }
        }
    }
}
