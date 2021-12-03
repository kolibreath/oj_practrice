import java.util.LinkedList;

public class 特定深度节点链表 {
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if(tree == null) return null;
            int depth = depth(tree);
            ListNode[] result = new ListNode[depth];
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            TreeNode end = tree;
            ListNode head = new ListNode(-1);
            int count = 0;
            while(!queue.isEmpty()) {
                TreeNode out = queue.poll();

                ListNode node = new ListNode(out.val);
                addListNode(head, node);

                if(out.left != null) queue.add(out.left);
                if(out.right != null) queue.add(out.right);

                if(out == end) {
                    result[count++] = head.next;
                    head.next = null;
                    if (queue.size() == 0) break;
                    end = queue.getLast();
                }
            }
            return result;
        }

        private void addListNode(ListNode head, ListNode node) {
            while(head.next != null) head = head.next;
            head.next = node;
        }

        private int depth(TreeNode root) {
            if(root == null) return 0;
            int left = depth(root.left);
            int right = depth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
