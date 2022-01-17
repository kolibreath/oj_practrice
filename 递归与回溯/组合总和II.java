import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // 先讲candicates进行排序 相同的组合剔除掉
            Arrays.sort(candidates);
            vis = new boolean[candidates.length];
            dfs(candidates, 0, target, new ArrayList<>());
            return ans;
        }

        private boolean[] vis ;
        private List<List<Integer>> ans = new ArrayList<>();
        private void dfs(int[]nums, int i, int target, ArrayList<Integer> perms) {
            if (target == 0) {
                ans.add(new ArrayList<>(perms));
                return;
            }
            for (int j = i;  j < nums.length; j++) {
                if ( j > 0 && nums[j] == nums[j-1] && !vis[j-1]) continue;
                int result = target - nums[j];
                if (result < 0) continue;
                perms.add(nums[j]);
                vis[j] = true;
                dfs(nums, j + 1, result, perms);
                vis[j] = false;
                perms.remove(perms.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        组合总和II.Solution solution = new 组合总和II.Solution();
        int nums[] = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> t = solution.combinationSum2(nums, target);
        for (int i = 0; i < t.size(); i++) {
            for (int k: t.get(i)) {
                System.out.print(k+ " ");
            }
            System.out.println();
        }
    }
}
