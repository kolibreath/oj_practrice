public class 删除链表中的重复元素II {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(Integer.MAX_VALUE);
            dummy.next = head;
            ListNode cur = dummy;
            while(cur.next != null && cur.next.next!= null){
                if(cur.next.val == cur.next.next.val){
                    ListNode temp = cur.next;
                    while(temp != null && temp.val == cur.next.val){
                        temp = temp.next;
                    }
                    cur.next = temp;
                }else
                    cur = cur.next;
            }
            return dummy.next;
        }
    }
}
