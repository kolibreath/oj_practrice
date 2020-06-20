public class 路径总和 {
    class Solution {
        private boolean dfs(TreeNode node, int sum, int cur){
            if(node == null) return false;
            cur += node.val;
            if(node.left == null && node.right == null && sum == cur ) return true;
            if(node.left == null && node.right == null) return false;
            return dfs(node.left, sum, cur) || dfs(node.right, sum, cur);
        }
        public boolean hasPathSum(TreeNode root, int sum) {
            return dfs(root, sum, 0);
        }
    }
}
