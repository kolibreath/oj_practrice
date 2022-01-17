import java.util.HashMap;

public class LruCache {
    static class LRUCache {
        class Node {
            int key;
            int value;
            Node prev, next;
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final HashMap<Integer, Node> map = new HashMap<>();
        private int size = 0;
        private final Node head;
        private final Node tail;
        private final int capacity;

        public LRUCache(int capacity) {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node cur = map.get(key);
            if (cur == null) return -1;
            // 找到对应的节点 并且移到头
            move2head(cur);
            return cur.value;
        }

        private void add2head(Node node) {
            Node headNext = head.next;
            node.next = headNext;
            headNext.prev = node;

            head.next = node;
            node.prev = head;
        }

        private void deleteNode(Node node) {
            Node curPrev = node.prev;
            Node curNext = node.next;
            curPrev.next = curNext;
            curNext.prev = curPrev;

            node.next = null;
            node.prev = null;
        }

        private void move2head(Node node) {
            deleteNode(node);
            add2head(node);
        }

        public void put(int key, int value) {
            Node cur = map.get(key);
            if (cur == null){
                Node node = new Node(key, value);
                map.put(key, node);
                add2head(node);
                size ++;
            } else {
                cur.value = value;
                move2head(cur);
            }

            if (size > capacity) {
                // 删除末尾的节点
                Node lastNode = tail.prev;
                deleteNode(lastNode);
                map.remove(lastNode.key);
                size --;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
