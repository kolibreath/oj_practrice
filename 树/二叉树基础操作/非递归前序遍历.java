import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 非递归前序遍历 {
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) {
                if(root == null) return new ArrayList<>();
                List<Integer> result = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                while(root != null || !stack.isEmpty()) {
                    while (root != null) {
                        result.add(root.val);
                        stack.push(root);
                        root = root.left;
                    }
                    root = stack.pop().right;
                }
                return result;
            }
        }
}
