import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 非递归中序遍历 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null ) return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode top = stack.pop();
                result.add(top.val);
                root = top.right;
            }
            return result;
        }
    }
}
