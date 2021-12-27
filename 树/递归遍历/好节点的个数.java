public class 好节点的个数 {
    class Solution {
        public int goodNodes(TreeNode root) {
            dfs(root, root.val);
            return n;
        }

        private int n = 0;
        private void dfs(TreeNode node, int max) {
            if (node == null) return;
            if (node.val >= max) n ++;
            dfs(node.left, Math.max(max, node.val));
            dfs(node.right, Math.max(max, node.val));
        }
    }
}
