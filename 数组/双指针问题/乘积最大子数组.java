public class 乘积最大子数组 {
    //    https://leetcode-cn.com/problems/maximum-product-subarray/
    static class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int time = 1;
                for(int j = i; j < nums.length; j++){
                    time *= nums[j];
                    if(time > max){
                       max = time;
                    }
                }
            }
            return max;
        }
    }
}
