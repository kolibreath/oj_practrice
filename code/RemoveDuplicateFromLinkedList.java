public class RemoveDuplicateFromLinkedList {

    public static  class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static class Solution {
        public ListNode deleteDuplicates(ListNode real) {
            if(real == null || real.next == null)
                return real;
            real.next = deleteDuplicates(real.next);
            return real.val == real.next.val ? real.next : real;
        }
    }
}
