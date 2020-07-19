import java.util.LinkedList;
import java.util.List;

public class 二叉树所有路径 {
    static class Solution {
        LinkedList<String> result = new LinkedList<>();
        private void helper(TreeNode node, String builder){
            if(node == null) return;
            if(node.left == null && node.right == null) {
                builder += node.val;
                result.add(builder);
                return;
            }
            builder += node.val + "->";
            helper(node.left, builder);
            helper(node.right, builder);
        }
        public List<String> binaryTreePaths(TreeNode root) {
            helper(root,"");
            return result;
        }
    }
}
