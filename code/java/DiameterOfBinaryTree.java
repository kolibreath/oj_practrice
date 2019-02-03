public class DiameterOfBinaryTree {


     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class  Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            if (root.left == null && root.right == null)
                return 1;

            int left = 0;
            if (root.left.left == null && root.left.right == null) {
                left = 0;
            } else {
                left = getHeight(root.left, 0);
                ;
            }

            int right = 0;
            if (root.right.left == null && root.right.right == null) {
                right = 0;
            } else {
                right = getHeight(root.right, 0);
                ;
            }

            return left + right + 1;

        }

        public int getHeight(TreeNode root, int height) {
            if (root == null)
                return height;

            return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
        }
    }
}
