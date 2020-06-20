public class 二叉搜索树的最小距离 {
    static class Solution {
        Integer pre = null, min = Integer.MAX_VALUE;
        private void helper(TreeNode node){
            if(node == null) return;
            helper(node.left);
            if(pre != null)   min = Math.min(min, node.val - pre);
            pre = node.val;
            helper(node.right);
        }
        public int minDiffInBST(TreeNode node) {
            helper(node);return min;
        }
    }
}
