import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N叉树的最大深度 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public int maxDepth(Node root) {
            if( root == null) return 0;
            LinkedList<Integer> depths = new LinkedList<>();
            for (int i = 0; i <root.children.size() ; i++) {
                int depth = maxDepth(root.children.get(i));
                depths.add(depth);
            }
            if(depths.size() == 0) return 1;
            Collections.sort(depths);
            return depths.get(depths.size() - 1) + 1;
        }
    }
}
