public class 最大子数组和 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int prev = nums[0];
            int max = nums[0];
            for(int i = 1; i < n; i ++ ) {
                int cur = nums[i];
                int value = prev + cur;
                if(value > cur) nums[i] = value;
                max = Math.max(max, Math.max(value, cur));
                prev = nums[i];
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1};
        System.out.println(solution.maxSubArray(nums));
    }
}
