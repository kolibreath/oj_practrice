public class 二叉搜索树的范围和 {
    class Solution {
        private int ans = 0;
        private void dfs(TreeNode node, int l,int r){
            if(node == null) return ;
            if(node.val >= l && node.val <= r) ans += node.val;
            if(node.val > l) dfs(node.left, l,r);
            if(node.val < r) dfs(node.right,l,r);
        }
        public int rangeSumBST(TreeNode root, int L, int R) {
          dfs(root,L,R);
          return ans;
        }
    }
}
