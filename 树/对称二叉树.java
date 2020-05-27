public class 对称二叉树 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return symmetric(root, root);
        }

        public boolean symmetric(TreeNode left, TreeNode right){
            if(left == null && right == null)return true;
            if(left == null || right == null)return false;
            return (left.val == right.val) && symmetric(left.right, right.left) && symmetric(left.left, right.right);
        }
    }
}
