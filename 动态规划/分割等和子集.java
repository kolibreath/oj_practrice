public class 分割等和子集 {
    static class Solution {
        public boolean canPartition(int[] nums) {
            // 计算总量
            int sum = 0;
            for (int num : nums) sum += num;
            // 如果sum为奇数 直接返回false
            if ((sum & 1) == 1) return false;
            int target = sum / 2;
            // 使用动态规划
            int m = nums.length + 1;
            int n = target + 1;
            boolean[][] dp = new boolean[m][n];
            // 最后一行
            dp[m - 1][0] = true;
            for (int i = 1; i < n; i++) dp[m - 1][i] = false;

            for (int i = m - 2; i >= 0 ; i--) {
                for (int j = 0; j < n; j++) {
                    boolean value1 ;
                    if (j - nums[i] < 0) value1 = false;
                    else {
                        value1 = dp[i + 1][j - nums[i]];
                    }
                    boolean value2 = dp[i + 1][j];
                    dp[i][j] = value2 || value1;
                }
            }
            return dp[0][target];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}
