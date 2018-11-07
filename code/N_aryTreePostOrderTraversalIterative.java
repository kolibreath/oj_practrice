import java.util.*;

public class N_aryTreePostOrderTraversalIterative {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public List<Integer> postorder(Node root) {
            if (root == null)
                return new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                list.add(node.val);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
            return list;
        }
    }
}
