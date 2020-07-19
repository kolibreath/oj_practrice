public class 二叉树的直径 {
    class Solution {
        private int result = 0;
        private int dfs(TreeNode node){
            if(node == null) return 0;
            int left = dfs(node.left);
            int right = dfs(node.right);
            result = Math.max(result, left + right );
            return Math.max(left, right) + 1;
        }
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return result;
        }
    }
}
