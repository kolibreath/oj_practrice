public class 返回倒数K个节点 {
    static class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode cur = head;
            while( -- k > 0)
                cur = cur.next;
            ListNode p = head;
            while(cur.next != null){
                cur = cur.next;
                p = p.next;
            }
            return p.val;
        }
    }
}
