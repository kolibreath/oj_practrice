import java.util.ArrayList;
import java.util.LinkedList;

public class 环形子数组的最大和 {
    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            // 如果数组是环形的，使用数组综合减去数组中最小的连续数组的和
            int sum = 0;
            int max = nums[0];
            int min = nums[0];
            int prevMin = 0;
            int prevMax = 0;
            for (int cur : nums) {
                prevMax = Math.max(cur + prevMax, prevMax);
                max = Math.max(max, prevMax);
                prevMin = Math.min(cur + prevMin, prevMin);
                min = Math.min(min, prevMin);
                sum += cur;
            }
            if (sum == min) return max;
            else return Math.max(max, sum - min);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9,-4,-7,9};
        System.out.print(solution.maxSubarraySumCircular(nums));
    }
}
