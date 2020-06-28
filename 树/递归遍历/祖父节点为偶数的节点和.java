public class 祖父节点为偶数的节点和 {
    class Solution {
        private int ans = 0;
        private void dfs(TreeNode node, TreeNode father, TreeNode grand){
            if(node == null) return;
            if(grand != null && grand.val % 2 == 0) ans += node.val;
            dfs(node.left, node, father);
            dfs(node.right, node, father);
        }
        public int sumEvenGrandparent(TreeNode root) {
            dfs(root, null, null);
            return ans;
        }
    }
}
