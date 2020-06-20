public class 二叉树的镜像 {
    class Solution {
        private void helper(TreeNode node){
            if(node == null) return;
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            helper(node.left);
            helper(node.right);
        }
        public TreeNode mirrorTree(TreeNode node) {
            helper(node);
            return node;
        }
    }
}
