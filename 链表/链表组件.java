import java.util.*;

public class 链表组件 {
    static class Solution {
        public int numComponents(ListNode head, int[] g) {
            ListNode cur = head;
            List<Integer> set = new LinkedList<>();
            for (int i:g)
                set.add(i);
            int max = 0;
            int i = 0;
            while(cur != null){
                if(set.contains(cur.val)){
                    i++;
                }else{
                    i = 0;
                }
                if(i > max) max = i;
                cur = cur.next;
            }
            return max;
        }
    }
}
