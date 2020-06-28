public class 最大二叉树 {
    static class Turple{
        int max;
        int index;
        public Turple(int max, int index){
            this.max = max;
            this.index = index;
        }
    }
    static class Solution {
        public TreeNode dfs(int[] nums, int low, int high){
            if(low > high) return null;

            Turple max = find(nums, low, high);
            TreeNode mid = new TreeNode(max.max);
            mid.left = dfs(nums, low, max.index - 1);
            mid.right = dfs(nums, max.index + 1, high);
            return mid;
        }
        private Turple find(int[] nums, int low, int high){
            int max = nums[low];
            int index= low;
            for (int i = low+1; i <= high ; i++) {
                if(max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            return new Turple(max, index);
        }
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if(nums == null|| nums.length == 0) return null;
            return dfs(nums, 0 , nums.length -1);
        }
    }
}
