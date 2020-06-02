public class 删除排序链表中的重复元素 {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(Integer.MAX_VALUE);
            dummy.next = head;
            ListNode p = dummy;
            ListNode q = head;
            while(q!= null){
                if(p.val == q.val){
                    while(q != null && p.val == q.val)
                        q = q.next;
                    p.next = q;
                }else{
                    p = p.next;
                    q = q.next;
                }
            }
            return dummy.next;
        }
    }
}
