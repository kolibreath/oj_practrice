public class 翻转二叉树 {
    class Solution {
        private void dfs(TreeNode root){
            if(root == null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            dfs(root.left);
            dfs(root.right);
        }
        public TreeNode invertTree(TreeNode root) {
            dfs(root);
            return root;
        }
    }

}
