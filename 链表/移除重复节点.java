import java.util.LinkedList;

public class 移除重复节点 {
    static class Solution {
        LinkedList<Integer> list = new LinkedList<>();
        public ListNode removeDuplicateNodes(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            ListNode cur = head;
            dummy.next = head;
            while(cur != null){
                if(list.contains(cur.val)){
                    pre.next = cur.next;
                }else{
                    list.add(cur.val);
                    pre = pre.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
