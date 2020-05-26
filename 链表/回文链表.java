public class 回文链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) return true;
            ListNode firstHalfEnd = findFirstHalf(head);
            ListNode secondHalfEnd = reverseList(firstHalfEnd.next);

            ListNode p = head;
            ListNode q = secondHalfEnd;
            while(p != null && q != null){
                if(p.val != q.val) return false;
                p = p.next;
                q = q.next;
            }
            return true;
        }

        public ListNode findFirstHalf(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head){
            ListNode cur = head;
            ListNode pre=  null;
            while(cur != null){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

    }
}
