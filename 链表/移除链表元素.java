public class 移除链表元素 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy, cur = head;
            while (cur != null){
                if(cur.val == val)
                    pre.next = cur.next;
                else
                    pre = pre.next;
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
