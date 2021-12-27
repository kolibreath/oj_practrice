import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 删除并获得点数 {
    static class Solution {
        public int deleteAndEarn(int[] arr) {
            return dfs(arr, 0, new HashSet<Integer>());
        }

        private int dfs(int[]nums, int index, HashSet<Integer> ban) {
            if (index == nums.length) return 0;
            HashSet<Integer> temp = new HashSet<>(ban);
            temp.add(nums[index] + 1); temp.add(nums[index] - 1);
            // deleted
            int value;
            if (ban.contains(nums[index]))
                value = 0;
            else
                value = nums[index];
            int deleted = dfs(nums, index + 1, temp) + value;
            int undeleted = dfs(nums, index + 1, ban);
            return Math.max(deleted, undeleted);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {2,2,3,3,3,4};
        System.out.println(solution.deleteAndEarn(nums));
    }
}
