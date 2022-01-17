public class 除自身以外数组的乘积 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] left = new int[nums.length];
            // 构造左边
            int last = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    left[i] = last;
                } else {
                    left[i] = nums[i-1] * left[i-1];
                }
            }
            // 构造右边
            for(int i = nums.length - 1; i >=0 ; i --) {
                if (i == nums.length - 1) {
                    last = 1;
                    left[i] = last * left[i];
                } else {
                    int t = last * nums[i + 1];
                    left[i] = left[i] * t;
                    last = t;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int[] ans = solution.productExceptSelf(nums);
    }
}
