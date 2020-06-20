public class 最小二叉树 {
    static class Solution {
        private TreeNode dfs(int []num, int left ,int right){
            if(left > right ) return null;
            int mid = (left + right) /2 ;
            TreeNode midTreeNode = new TreeNode(num[mid]);
            midTreeNode.left = dfs(num, left , mid -1);
            midTreeNode.right = dfs(num,mid + 1 , right);
            return midTreeNode;
        }
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return dfs(nums, 0, nums.length - 1);
        }
    }
}
