public class 排序链表 {
    static class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null)return head;
            //要分成两个部分
            ListNode slow = head;
            ListNode fast = head;
            //使用双向链表的前中法
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            //暂存slow的next
            ListNode next = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right= sortList(next);

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while(left != null && right != null){
                if(left.val < right.val){
                    cur.next = left;
                    left = left.next;
                }else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            cur.next = left == null ? right : left;
            return dummy.next;
        }
    }
}
