public class 单值二叉树 {
    class Solution {
        private boolean dfs(TreeNode node, int value){
            if(node == null) return true;
            if(node.val != value) return false;
            return dfs(node.left, value) && dfs(node.right,value);
        }
        public boolean isUnivalTree(TreeNode root) {
            return dfs(root, root.val);
        }
    }
}
