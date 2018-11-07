import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofN_aryTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    static class Solution {
        Node root = new Node();

        public void initFirst(Node root, int rootValue, int start, int end) {
            List<Node> firstNodes = new ArrayList<>();
            root.val = rootValue;
            for (int i = start; i <= end; i++) {
                Node node = new Node();
                node.val = i;
                firstNodes.add(node);
            }
            root.children = firstNodes;
        }


        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            Queue<Node> list = new LinkedList<>();

            list.add(root);
            int counter = 0;

            while (!list.isEmpty()) {
                counter++;

                int c = list.size();
                for (int i = 0; i < c; i++) {
                    Node node = list.poll();
                    for (Node n : node.children) {
                        list.add(n);
                    }
                }
            }
            return counter;
        }
    }
}
