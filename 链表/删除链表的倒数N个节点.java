public class 删除链表的倒数N个节点 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy, second = dummy;
            while(n-->0){
                second = second.next;
            }
            while(second.next!=null){
                first = first.next;
                second = second.next;
            }
            first.next = first.next.next;
            return dummy.next;
        }
    }
}
