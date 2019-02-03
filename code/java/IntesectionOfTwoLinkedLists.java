public class IntesectionOfTwoLinkedLists {
    public static  class Solution {
        public ListNode getIntersectionNode(ListNode a, ListNode b) {

            if(a == null || b == null)
                return null;

            ListNode ap = a;
            ListNode bp = b;
            while(ap != bp){
                ap = ap == null ? b : ap.next;
                bp = bp == null ? a : ap.next;
            }

            return ap;
        }
    }
}
