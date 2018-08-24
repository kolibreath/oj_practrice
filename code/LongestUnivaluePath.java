public class LongestUnivaluePath {
    class Solution {
        private int res = 0;
        public int longestUnivaluePath(TreeNode root) {
            if(root == null)
                return 0;
            helper(root);
            return res;
        }


        private int helper(TreeNode node ){
            if(node ==null)
                return 0;
            int left = helper(node.left);
            int right = helper(node.right);

            left = node.left != null && node.val== node.left.val ? left + 1: 0;
            right = node.right != null && node.val== node.right.val ? right + 1: 0;

            res = Math.max(res,left+ right);
            return res;
        }
    }
}
