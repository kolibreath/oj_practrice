public class  求根节点到叶节点数字之和{
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        public int helper(TreeNode node, int presum){
            if (node == null) return 0;
            int sum = 10 * presum + node.val;
            if (node.left == null && node.right == null) return sum;
            else 
                return helper(node.left, sum) + helper(node.right, sum);
        }
    }
}