public class 二叉树的最大深度 {
    class Solution {
//        https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
        public int maxDepth(TreeNode node) {
            if(node == null) return 0;
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
    }
}
