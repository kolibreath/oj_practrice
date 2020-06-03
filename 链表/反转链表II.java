public class 反转链表II {
    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int length = n - m + 1;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while(--m > 0)
                cur = cur.next;
            cur.next = reverseList(cur.next,length);
            return dummy.next;
        }

        public ListNode reverseList(ListNode node, int length){
            ListNode pre = null;
            ListNode cur = node;
            while(  length -- > 0){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
//            if(pre != null) pre.next = cur;
            return pre;
        }
    }
}
