public class 最小高度树 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return dfs(nums,0,nums.length-1);
        }

        private TreeNode dfs(int[]nums, int left, int right){
            if (left > right) return null;
            int mid = (left + right)/2;
            TreeNode cur = new TreeNode(nums[mid]);
            cur.left = dfs(nums,left,mid-1);
            cur.right= dfs(nums,mid+1,right);
            return cur;
        }
    }
}