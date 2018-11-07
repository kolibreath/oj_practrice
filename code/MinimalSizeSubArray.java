public class MinimalSizeSubArray {

    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;

            int i = 0, j = 0, min = Integer.MAX_VALUE;
            int sum = 0;
            while (j < nums.length) {
                sum += nums[j];
                while (sum >= s) {
                    sum -= nums[i];
                    min = Math.min(min,j - i );
                    i++;
                }
                j++;
            }
            return min == Integer.MAX_VALUE ? 0 : min + 1;
        }

    }
}
