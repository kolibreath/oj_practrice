public class 最大子序和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int pre = 0;
            for (int i = 0 ; i < nums.length; i++){
                pre = Math.max(pre, pre + nums[i]);
                max = Math.max(pre,max);
            }
            return max;
        }
    }
}