import java.util.ArrayList;
import java.util.List;

public class 组合 {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            int[]nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = i + 1;
            dfs(nums, k, 0, new ArrayList<>());
            return ans;
        }

        private List<List<Integer>> ans = new ArrayList<>();
        private void dfs(int[]nums, int k ,int start, ArrayList<Integer> path) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < nums.length ; i++) {
                // 剩下的所有的长度
                int rest = nums.length - start;
                int need = k-path.size();
                if (rest < need) return;
                path.add(nums[i]);
                dfs(nums, k ,i + 1, path);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1;
        int k = 1;
        List<List<Integer>> t = solution.combine(n, k);
        for (List<Integer> integers : t) {
            for (int j : integers) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
