public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
   static class Solution {
        public ListNode reverseList(ListNode head) {

            if(head == null)
                return null;
            ListNode dummy = new ListNode(0);
            reverse(head,dummy,null);

            return dummy.next;
        }

        void reverse(ListNode node,ListNode dummy,ListNode cur){
            if(node.next == null) {
                dummy.next= node;
                return;
            }

            reverse(node.next,dummy,cur);
            ListNode p = dummy;
            while(p.next!=null){
                p = p.next;
            }
            cur = p;
            cur.next = new ListNode(node.val);
        }
    }

}
