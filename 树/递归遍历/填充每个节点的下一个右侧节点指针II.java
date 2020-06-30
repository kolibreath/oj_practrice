import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II {

    static class Solution {
        public Node connect(Node root) {
            if(root == null) return null;
            Queue<Node> queue = new LinkedList<>();
            root.next = null;
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                LinkedList<Node> temp = new LinkedList<>();
                for (int i = 0; i < size ; i++) {
                    Node cur = queue.poll();
                    if(cur.left != null) {
                        queue.add(cur.left);
                        temp.add(cur.left);
                    }
                    if(cur.right != null) {
                        queue.add(cur.right);
                        temp.add(cur.right);
                    }
                }
                if(temp.isEmpty()) break;
                Node node = temp.get(0);
                for (int i = 1; i <  temp.size(); i++) {
                    node.next = temp.get(i);
                    node = temp.get(i);
                }
                temp.getLast().next = null;
            }
            return root;
        }
    }
}
