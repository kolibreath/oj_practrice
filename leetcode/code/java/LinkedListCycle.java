public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head  == null || head.next == null)
                return false;
            ListNode walker = head;
            ListNode runner = head;
            while(runner.next!=null && runner.next.next != null){
                walker = walker.next;
                runner = runner.next .next;
                if(runner== walker){
                    return true;
                }
            }
            return false;
        }
    }
}
