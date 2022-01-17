import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, 0, target, new ArrayList<>());
            return ans;
        }

        private List<List<Integer>> ans = new ArrayList<>();
        private void dfs(int[]nums, int i, int target, ArrayList<Integer> perms) {
            if (target == 0) {
                ans.add(new ArrayList<>(perms));
                return;
            }
            for (int j = i; j < nums.length ; j++) {
                int result = target - nums[j];
                if (result < 0) continue;
                perms.add(nums[j]);
                dfs(nums, j, result, perms);
                perms.remove(perms.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {2,3,6,7};
        int target = 7;
        List<List<Integer>> t = solution.combinationSum(nums, target);

    }
}
