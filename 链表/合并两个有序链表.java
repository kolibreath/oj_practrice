public class 合并两个有序链表 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            ListNode p = l1, q = l2;
            while(p != null && q != null){
                if(p.val < q.val){
                    cur.next = new ListNode(p.val);
                    p = p.next;
                }else {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                }
                cur = cur .next;
            }
            while(p!= null){
                cur.next = new ListNode(p.val);
                p = p.next;
                cur = cur.next;
            }

            while (q !=null){
                cur.next = new ListNode(q.val);
                q = q.next;
                cur = cur.next;
            }

            return dummy.next;
        }
    }
}
