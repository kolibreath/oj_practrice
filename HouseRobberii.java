import java.util.Arrays;

public class HouseRobberii {
    static class Solution {
        public int rob(int[] nums) {
            return Math.max(rob(nums, 0, nums.length - 1),
                    rob(nums, 1, nums.length));
        }

        int rob(int nums[], int left, int right) {
            if (right - left <= 1) return nums[left];
            int dp[] = new int[nums.length];
            Arrays.fill(dp, 0);
            dp[left] = nums[left];
            dp[left + 1] = Math.max(nums[left], nums[left + 1]);
            for (int i = left + 2; i < right; ++i) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[dp.length - 1];
        }
    }
}
