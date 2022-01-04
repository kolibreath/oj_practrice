import java.util.ArrayList;
import java.util.List;

public class 全排列vis {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            vis = new boolean[nums.length];
            dfs(0, nums, new ArrayList<>());
            return result;
        }

        private boolean[] vis ;
        List<List<Integer>> result = new ArrayList<>();
        private void dfs(int i, int[]nums, ArrayList<Integer> perm) {
            if (i == nums.length) {
                result.add(new ArrayList<>(perm));
                return;
            }
            for (int j = 0; j < nums.length; j++) {
                if (vis[j]) continue;
                vis[j] = true;
                perm.add(nums[j]);
                dfs(i+1, nums, perm);
                vis[j] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
