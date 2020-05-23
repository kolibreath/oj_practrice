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
    }
}
