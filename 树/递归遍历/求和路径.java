public class 求和路径 {
    public class Solution {

        private int ret = 0;

        public int pathSum(TreeNode root, int sum) {
            preOrder(root, sum);
            return ret;
        }

        /**
         * 从root结点出发，求路径和等于sum路径数
         *
         * @param root
         * @param sum
         */
        private void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            if (root.val == sum) {
                ret++;
            }
            dfs(root.left, sum - root.val);
            dfs(root.right, sum - root.val);
        }

        /**
         * 题目要求可以从每个结点出发，每个结点调用一次dfs
         *
         * @param root
         * @param sum
         */
        private void preOrder(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            dfs(root, sum);
            preOrder(root.left, sum);
            preOrder(root.right, sum);
        }
    }

}