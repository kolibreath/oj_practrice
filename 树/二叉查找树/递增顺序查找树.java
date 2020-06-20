public class 递增顺序查找树 {
    static class Solution {
        private TreeNode result = new TreeNode(-1);
        private void dfs(TreeNode root){
            if(root == null) return ;
            dfs(root.left);
            result.left = null;
            result.right = new TreeNode(root.val);
            result = result.right;
            dfs(root.right);
        }
        public TreeNode increasingBST(TreeNode root) {
            TreeNode cur = result;
            dfs(root);
            return cur.right;
        }
    }
}
