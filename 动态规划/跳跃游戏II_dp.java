public class 跳跃游戏II_dp {
    static class Solution {
        public int jump(int[] nums) {
            int[]dp = new int[nums.length];
            for(int i = 1; i < nums.length; i ++) dp[i] = Integer.MAX_VALUE;
            dp[0] = 0;
            for (int i = 0; i < nums.length; i ++) {
                int maxLength = nums[i];
                for(int j = i + maxLength; j > i; j -- ) {
                    if (j >= nums.length) continue;
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
            return dp[nums.length-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {2,3,0,1,4};
        System.out.println(solution.jump(nums));
    }
}
