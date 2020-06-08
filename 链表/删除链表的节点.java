public class 删除链表的节点 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;
            while(cur != null){
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
