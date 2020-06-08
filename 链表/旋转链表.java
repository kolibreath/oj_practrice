import com.sun.xml.internal.ws.api.message.AddressingUtils;

public class 旋转链表 {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            int listSize= listLength(head);
            if(listSize == 0) return head;
            k = k % listSize;
            if(k == 0) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy, p = head, q = head  ;
            while(--k>0){
                q = q.next;
            }
            while(q.next!=null){
                q  =q.next;
                pre= pre.next;
                p = p.next;
            }
            pre.next = null;
            q.next =  dummy.next;
            return p;
        }

        public int listLength(ListNode head){
            ListNode cur = head;
            int count = 0;
            while(cur!= null){
                count++;
                cur = cur.next;
            }
            return count;
        }
    }
}
