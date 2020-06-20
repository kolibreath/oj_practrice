public class 二叉搜索树变成累加树 {
    static class Solution {
        int sum = 0;
        private void traverse(TreeNode node){
            if(node == null ) return;
            traverse(node.right);
            sum += node.val;
            node.val = sum;
            traverse(node.left);
        }
        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }
    }
}
