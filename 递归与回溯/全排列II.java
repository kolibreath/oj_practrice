import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 全排列II {
    static class Solution {
        private boolean [] visited ;
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            visited = new boolean[nums.length];
            dfs(0, new ArrayList<>(), nums);
            return result;
        }

        private List<List<Integer>> result = new ArrayList<>();
        private void dfs(int i, ArrayList<Integer> perms, int[]nums) {
            if (i == nums.length) {
                result.add(new ArrayList<>(perms));
                return;
            }

            for (int j = 0; j < nums.length; j++) {
                if (visited[j] || (j > 0 && nums[j] == nums[j-1] && !visited[j-1])) continue;
                perms.add(nums[j]);
                visited[j] = true;
                dfs(i+1, perms, nums);
                visited[j] = false;
                perms.remove(perms.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {0,9,0,0,1};
        List<List<Integer>> result = solution.permuteUnique(nums);
        for(List<Integer> list : result) {
            for(int i : list) System.out.print(i);
            System.out.println();
        }
    }
}
