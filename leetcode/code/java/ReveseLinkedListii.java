public class ReveseLinkedListii {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //todo 没有通过测试
    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy .next = head;

            ListNode cur  = head;
            for(int i= 0;i<m-1;i++) cur = cur.next;

            ListNode pre = head;
            ListNode tail = cur;

            ListNode last = cur.next;
            for(int i = m;i<n;i++){
                pre.next = last;
                cur.next = last.next;
                last.next = cur;

                ListNode temp = last;
                last = cur;
                cur = temp;

                last = last.next;
                tail = tail.next;

            }

            return dummy.next;
        }
    }
}
