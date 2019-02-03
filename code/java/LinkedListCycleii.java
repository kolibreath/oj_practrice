public class LinkedListCycleii {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static class Solution {
        public ListNode detectCycle(ListNode head) {

            if(head == null)
                return null;
            //如果只有一个节点 而且节点的next 指向的是自己

            if(head.next == null)
                return null;

            if(head.next == head)
                return head;

            ListNode fast = head;
            ListNode slow = head;
            ListNode firstMeeting = head;

            boolean isCycle=  false;
            //不能直接使用true
            //这样的话如果是一个非cycle的list 无法break
            while( fast != null && slow!=null){
                if(fast.next == null)
                    break;
                fast = fast.next.next;
                slow = slow.next;
                firstMeeting = firstMeeting.next;
                if(fast == slow) {
                    isCycle = true;
                    break;
                }
            }

            if(!isCycle)
                return null;

            while(true){
                if(head == firstMeeting)
                    break;
                head = head.next;
                firstMeeting = firstMeeting.next;
            }

            return firstMeeting;
        }
    }
}
