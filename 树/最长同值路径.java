public class 最长同值路径 {
    class Solution {
        public int dfs(TreeNode root, int max){
            if(root == null) return max;
            int left = max;
            int right = max;
            if(root.val == root.left.val) left =  dfs(root.left, max + 1);
            if(root.val == root.right.val) right = dfs(root.right, max + 1);
            return Math.max(left, right);
        }
        public int longestUnivaluePath(TreeNode root) {
            return dfs(root, -1);
        }
    }
}
