import java.util.ArrayList;

public class 将有序链表变成二叉搜索树 {
    class Solution {

        public ListNode findMiddleElement(ListNode node){
            ListNode prev = null;
            ListNode slow = node;
            ListNode fast = node;
            while(fast != null && fast.next != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if(prev != null) prev.next = null;
            return slow;
        }

        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            ListNode mid = findMiddleElement(head);

            if(mid == head) return new TreeNode(mid.val);

            TreeNode midTreeNode = new TreeNode(mid.val);
            midTreeNode.left = sortedListToBST(head);
            midTreeNode.right = sortedListToBST(mid.next);
            return midTreeNode;
        }
    }
}
