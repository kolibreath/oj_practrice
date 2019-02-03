public class Partitionlist{

   static class Solution {
        public ListNode partition(ListNode head, int x) {
            if(head == null)
                return null;

            ListNode node1 = new ListNode(0);
            ListNode node2 = new ListNode(0);

            ListNode p1 = node1;
            ListNode p2 = node2;

            while(head!= null){
                if(head.val < x){
                    p1 .next = head;
                    p1 = p1.next;
                }else{
                    p2.next=  head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p2.next = null;
            p1.next = node2.next;
            return node1.next;
        }
    }
}
