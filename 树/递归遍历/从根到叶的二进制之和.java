import java.util.LinkedList;
import java.util.List;

public class 从根到叶的二进制之和 {
    static class Solution {
        public int helper(TreeNode root, int sum){
            if(root == null) return 0;
            sum = (sum << 1) + root.val;
            if(root.left == null && root.right == null) return sum;
            return helper(root.left, sum) + helper(root.right, sum);
        }
        public int sumRootToLeaf(TreeNode root) {
            return helper(root,0);
        }
    }
}
