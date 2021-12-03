import java.util.Stack;

public class 二叉搜索树中第K小的元素 {
    class Solution {
        private int count = 0;
        private int result = 0;

        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                if(stack.peek().left != null) {
                    stack.push(stack.peek().left);
                    continue;
                }
                k --;
                if(k == 0) return stack.peek().val;
                else stack.pop();

                if(stack.peek().right != null) {
                    stack.push(stack.peek().right);
                }
            }
            return -1;
        }

    }
}
