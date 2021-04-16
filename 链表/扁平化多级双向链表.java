public class 扁平化多级双向链表 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    class Solution {
        public Node flatten(Node head) {
            return dfs(head);
        }
    }

    //返回当前递归到的链表的末尾的节点
    private Node dfs(Node node){
        if (node.next == null && node.child == null) return node;
        Node ptr = node;
        while(ptr != null){
            if (ptr.child != null){
                Node preNext = ptr.next;
                Node next = dfs(ptr.child);
                ptr.next = ptr.child;
                ptr.child = null;
                next.next = preNext;
                preNext.prev = next;              
            }
            ptr = ptr.next;
        }
        return node;
    }
}