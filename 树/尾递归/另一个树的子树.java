public class 另一个树的子树 {
    class Solution {
        private boolean same(TreeNode s, TreeNode t){
            if(s == null && t == null ) return true;
            if(s == null || t == null) return false;
            if(s.val != t.val) return false;
            return same(s.left, t.left) && same(s.right, t.right);
        }

        private boolean dfs(TreeNode s, TreeNode t){
            if(s == null) return false;
            return same(s, t) || dfs(s.left, t) || dfs(s.right, t);
        }
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return dfs(s, t);
        }
    }
}
