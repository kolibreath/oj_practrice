import java.util.HashMap;

public class 复制带随机指针的链表 {
    class Solution {
        HashMap<Node,Node> visitedHash = new HashMap<>();
        public Node copyRandomList(Node node) {
            if(node == null) return null;
            if(visitedHash.containsKey(node))
                return visitedHash.get(node);

            Node n = new Node(node.val);
            visitedHash.put(node, n);

            n.next = copyRandomList(node.next);
            n.random = copyRandomList(node.random);

            return n;
        }
    }
}
