public class 二叉搜索树到更大和树 {
    class Solution {
        private int sum = 0;
        private int  dfs(TreeNode root){
            if(root == null) return 0;
            int right = dfs(root.right);
            sum = sum + right;
            root.val = sum;
            int left = dfs(root.left);
            sum = sum + left;
            return sum ;
        }
        public TreeNode bstToGst(TreeNode root) {
            dfs(root);
            return root;
        }
    }
}