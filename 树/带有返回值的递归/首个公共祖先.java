public class 首个公共祖先 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            if(root.val == p.val || root.val == q.val) return root;
            boolean left = dfs(root.left, p, q);
            boolean right = dfs(root.right, p, q);
            if(left && right) return root;
            if(left) return lowestCommonAncestor(root.left, p, q);
            if(right) return lowestCommonAncestor(root.right, p, q);
            return null;
        }

        // root 为根的树中是否存在p或者q中的一个
        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return false;
           if(root.val == p.val || root.val == q.val) return true;
           return dfs(root.left, p, q) || dfs(root.right, p, q);
        }
    }
}
