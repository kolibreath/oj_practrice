public class 乘积最大子数组 {
    static class Solution {
        private int max ;
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int fmax;int fmin;int max ;
            max = fmax = fmin = nums[0];
            for (int i = 1; i < n; i++) {
                int a1 = nums[i];
                int a2 = a1 * fmax;
                int a3 = a1 * fmin;
                fmax = Math.max(a1, Math.max(a2, a3));
                fmin = Math.min(a1, Math.min(a2, a3));
                max = Math.max(max, fmax);
            }
            return max;
        }

        private void dfs(int[]nums, int index, int value) {
            if(index == nums.length ) {
                max = Math.max(max, value);
                return;
            }
            max = Math.max(max, value);
            // yes
            dfs(nums, index + 1, value * nums[ index + 1]);
            // no
            dfs(nums, index + 1, nums[index + 1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {2,3,-2,-4};
        System.out.println(solution.maxProduct(nums));
    }
}
