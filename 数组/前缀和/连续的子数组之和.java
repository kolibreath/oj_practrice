import java.util.ArrayList;
import java.util.HashMap;

public class 连续的子数组之和 {
    static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            return dfs(nums, k, 0, 0, new ArrayList<>());
        }

        private HashMap<Integer, Boolean> map = new HashMap<>();
        private boolean dfs(int[]nums, int k, int i , int sum, ArrayList<Integer> path) {
            if (map.getOrDefault(i, false)) return true;
            // sum % k == 0 && 是数组
            if (path.size() > 1 && sum % k == 0){
                return true;
            }
            // 此时没有返回true 说明此时到了结尾 但是还是false
            if (i == nums.length) return false;
            // 考虑当前
            path.add(nums[i]);
            boolean value1 = dfs(nums, k, i + 1, sum + nums[i], path);

            // 不考虑当前 传入下一个数 考虑特殊情况nums[i] % k == 0
            path = new ArrayList<>();
            path.add(nums[i]);
            boolean value2 = dfs(nums, k, i + 1, nums[i], path);
            boolean result = value1 || value2;
            map.put(i, result);
            return value1 || value2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        int k = 5;
        System.out.println(s.checkSubarraySum(nums, k));
    }
}
