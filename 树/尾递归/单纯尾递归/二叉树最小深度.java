public class 二叉树最小深度 {
    class Solution {
        public int minDepth(TreeNode root) {
          if(root == null) return 0;
          if(root.left == null && root.right == null) return 1;
          int m1 = minDepth(root.left);
          int m2 = minDepth(root.right);

          if(root.left == null || root.right == null) return m1 + m2 + 1;
          return Math.min(m1,m2 ) +1;
        }
    }
}
