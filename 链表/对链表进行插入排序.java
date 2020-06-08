import java.util.Collections;
import java.util.LinkedList;

public class 对链表进行插入排序 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            ListNode cur = head;
            while(cur!=null){
                linkedList.add(cur.val);
                cur = cur.next;
            }
            Collections.sort(linkedList);
            cur = head;
            int count = 0;
            while(cur != null){
                cur.val = linkedList.get(count++);
                cur = cur.next;
            }

            int x = 20 ,y = 30;
            int z = x > y ? x : y;
            return head;
        }
    }


}
