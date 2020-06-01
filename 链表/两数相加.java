import javax.swing.*;

public class 两数相加 {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p = l1, q = l2;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            int carry = 0;
            while(q!= null && p != null){
                int result = (p.val + q.val + carry) ;
                cur.next = new ListNode( result % 10);
                carry = ( result ) / 10;
                p = p.next;
                q = q.next;
                cur = cur.next;
            }
            while(p!=null){
                int result = p.val + carry;
                cur.next = new ListNode(result % 10);
                carry = result / 10;
                p = p.next;
                cur = cur.next;
            }

            while(q!=null){
                int result = q.val + carry;
                cur.next = new ListNode(result % 10 );
                carry = result / 10;
                q = q.next;
                cur = cur.next;
            }
            if(carry == 1)
                cur.next = new ListNode(carry);
            return dummy.next;
        }
    }
}
