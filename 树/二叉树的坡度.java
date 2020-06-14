public class 二叉树的坡度 {
    class Solution {
        private int tilt;
        public int findTilt(TreeNode root) {
            traverse(root);
            return tilt;
        }

        private int traverse(TreeNode node){
            if(node == null) return 0;
            int left = traverse(node.left);
            int right = traverse(node.right);

            tilt += Math.abs(left - right);
            return left + right + node.val;
        }
    }
}
