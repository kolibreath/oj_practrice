public class 二叉搜索树的第K大节点 {
    class Solution {
        private int ans = 0;
        private int k ;
        private void dfs(TreeNode root){
            if(root == null) return;
            dfs(root.right);
            if( k < 0) return;
            if(--k == 0) ans = root.val;
            dfs(root.left);
        }
        public int kthLargest(TreeNode root, int k) {
            this.ans = root.val;
            this.k = k;
            dfs(root);
            return ans;
        }
    }
}
