public class 反转链表 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode cur = head;
            while(cur!= null){
                ListNode node = new ListNode(cur.val);
                node.next = dummy.next;
                dummy.next = node;
                cur = cur.next;
            }
            return dummy.next;
        }

        public boolean isLoopExist(ListNode head){
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }
}
