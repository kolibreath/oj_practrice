@SuppressWarnings("ALL")
public class 两数相加 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;

            ListNode head = new ListNode(0);
            ListNode cur = head;
            while(l1 != null && l2 != null){
                int temp = l1.val + l2.val + carry;
                carry = temp / 10;
                cur.next = new ListNode(temp % 10);
                cur = cur.next;

                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null){
                int temp = l1.val + carry;
                carry = temp / 10;
                cur.next = new ListNode(temp%10);
                cur = cur.next;
                l1 = l1.next;
            }

            while(l2 != null){
                int temp = l2.val + carry;
                carry = temp / 10;
                cur.next = new ListNode(temp%10);
                cur = cur.next;
                l2 = l2.next;
            }

            if(carry == 1){
                cur.next = new ListNode(1);
            }

            return head.next;
        }
    }
}
