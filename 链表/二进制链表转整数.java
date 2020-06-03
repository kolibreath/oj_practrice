import java.util.LinkedList;

public class 二进制链表转整数 {
    static class Solution {
        public int getDecimalValue(ListNode head) {
            if(head == null) return 0;
            LinkedList<Integer> stack = new LinkedList<>();
            ListNode cur = head;
            while(cur != null){
                stack.add(cur.val);
                cur = cur.next;
            }
            int result = 0;
            while(!stack.isEmpty()){
                int value = stack.pop();
                result = result * 2 + value;
            }
            return result;
        }
    }
}
