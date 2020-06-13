import java.util.LinkedList;
import java.util.List;

public class N叉树的前序遍历 {
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
    };

    class Solution {
        private void dfs(Node node, LinkedList<Integer> list){
            if(node == null) return;
            list.add(node.val);
            for (Node n: node.children) {
                dfs(n, list);
            }
        }
        public List<Integer> preorder(Node root) {
            LinkedList<Integer> list = new LinkedList<>();
            dfs(root, list); return list;
        }
    }
}
