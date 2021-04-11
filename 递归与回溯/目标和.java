public class 目标和 {
    class Solution {
        // 表示不同的符号
        List<Integer> temp = new LinkedList<>();
        int all = 0;
        public int findTargetSumWays(int[] nums, int target) {
            dfs(0,0,nums, target);
            return all;
        }

        private void dfs(int index, int sum, int nums[], int target){
            if (index == nums.length) {
                if (sum == target) all++;
                return;
            }
            dfs(index+1, sum + nums[index], nums,target);
            dfs(index+1, sum - nums[index], nums,target);
        }
    }
}