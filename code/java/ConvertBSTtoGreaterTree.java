import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBSTtoGreaterTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            if (root == null)
                return null;
            int sum[] = new int[1];
            sum[0] = 0;
            helper(root, sum);

            return root;
        }

        public void helper(TreeNode root, int[] sum) {
            if (root == null)
                return;

            helper(root.right, sum);
            sum[0] = sum[0] + root.val;
            root.val = sum[0];
            helper(root.left, sum);
        }
    }
}
