import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            vis = new boolean[nums.length];
            dfs(nums, 0, new ArrayList<>());
            return ans;
        }

        private boolean[] vis ;
        private List<List<Integer>> ans = new ArrayList<>();
        // 不能包括重复的子集
        private void dfs(int[]nums, int level, ArrayList<Integer> perms) {
            if (level == nums.length) {
                ans.add(new ArrayList<>(perms));
                return;
            }
            // 不选
            dfs(nums, level + 1, perms);

            // 选择剪枝
            if (level > 0 && nums[level] == nums[level - 1] && !vis[level-1]) return;
            // 选择当前的level对应的
            vis[level] = true;
            perms.add(nums[level]);
            dfs(nums, level + 1, perms);
            vis[level] = false;
            perms.remove(perms.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {1,1,2,3};
        List<List<Integer>> t = solution.subsets(nums);
        for (int i = 0; i < t.size(); i++) {
            for (int k: t.get(i)) {
                System.out.print(k+ " ");
            }
            System.out.println();
        }
    }

}
