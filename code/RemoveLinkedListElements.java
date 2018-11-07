public class RemoveLinkedListElements {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy= new ListNode(0);
            dummy.next = head;

            ListNode pointer=  head;
            ListNode prev=  dummy;
            while(pointer !=null) {
                if (pointer.val == val) {
                    prev.next = pointer.next;
                    //这个时候删除这个节点！ 所以当前的pointer也要向后移动一位
                    pointer  = pointer.next;
                    continue;
                }
                prev = prev.next;
                pointer = pointer.next;
            }
            return dummy.next;
        }
    }
}
