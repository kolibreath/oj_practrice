import java.util.ArrayList;

public class 两数之和DFS {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            ArrayList<Integer> list = new ArrayList<>();
            dfs(nums, target, 0, list);
            // 因为题目中说明一定会有解 所以递归所有情况一定会有解
            return ans;
        }

        private int[] ans = new int[2];
        // dfs的是思路是进行数组内任意两个数字的组合的枚举 通过index 一直从左向右扫描
        private void dfs(int[]nums, int target, int index, ArrayList<Integer> list) {
            if (list.size() == 2 || index == nums.length) {
                // 如果当前的target == 0 -> return true 表示找到一组解
                // 如果当前的target != 0 -> return false 进行回溯
                if (target == 0 && list.size() == 2) {
                    ans[0] = list.get(0);
                    ans[1] = list.get(1);
                }
                return;
            }
            // 不考虑当前的数字
            dfs(nums, target, index + 1, list);
            // 考虑当前的数字
            // 将当前的数字的下标加入list target的值变成target - nums[index]
            list.add(index);
             dfs(nums, target-nums[index], index + 1, list);
            // 将当前的数字下标退出list
            list.remove(list.size()- 1);
        }
    }

    public static void main(String[] args) {
        int[]nums = {0,0};
        int target = 0;
        Solution solution = new Solution();
        int[] p = solution.twoSum(nums, target);
        for (int k : p)
            System.out.println(k);
    }
}
