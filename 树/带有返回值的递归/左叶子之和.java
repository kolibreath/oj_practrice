public class 左叶子之和 {
    static class Solution {
        private int sum(boolean left, TreeNode node){
            if(node == null) return 0;
            if(left && node.left == null && node.right == null) return node.val;
            return sum(true, node.left) + sum(false, node.right);
        }
        public int sumOfLeftLeaves(TreeNode root) {
            return sum(true, root);
        }
    }
}
