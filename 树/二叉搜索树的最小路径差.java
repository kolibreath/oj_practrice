public class 二叉搜索树的最小路径差 {
    class Solution {
        //中序遍历的一个搜索过程
        private int prev = -1;
        private int min = Integer.MAX_VALUE;
        private void helper(TreeNode node){
            if(node == null) return ;
            helper(node.left);
            if(prev == -1)
                prev = node.val;
            else{
                int cur = (node.val - prev);
                if(cur < min) min = cur;
                prev = node.val;
            }
            helper(node.right);
        }
        public int getMinimumDifference(TreeNode root) {
            helper(root);
            return min;
        }
    }
}
