import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 非递归后序遍历 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            TreeNode cur;
            TreeNode last = root;

            while(!stack.isEmpty()) {
                cur = stack.peek();
                if(cur.left != null && cur.left != last && cur.right != last) stack.push(cur.left);
                else if(cur.right != null && cur.right != last) stack.push(cur.right);
                else {
                    result.add(stack.pop().val);
                    last = cur;
                }
            }
            return result;
        }
    }
}
