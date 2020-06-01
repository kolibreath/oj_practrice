public class 奇偶链表 {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode jishu = new ListNode(0);
            ListNode oushu = new ListNode(0);

            ListNode cur = head;
            if(cur == null || cur.next == null) return head;
            ListNode temp = cur.next;

            jishu.next = cur;
            oushu.next = temp;

            while(true){
                temp = cur.next;
                if(temp.next == null ) {
                    cur.next = null;
                    break;
                }
                cur.next = temp.next;
                cur = temp;
            }
            ListNode p = jishu;
            while(p.next!= null){
                p = p.next;
            }
            p.next = oushu.next;
            return jishu.next;
        }
    }
}
