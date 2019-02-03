import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicatesFromSortedListii {
  static   class Solution {
        public ListNode deleteDuplicates(ListNode real) {
            if(real == null )
                return null;

            int cur = real.val;
            ListNode head = real.next;
            List<Integer> duplicates = new LinkedList<>();
            while(head!= null){
                if(cur == head.val){
                    duplicates.add(head.val);
                }
                cur = head.val;
                head = head.next;
            }

            ListNode p = real;
            ListNode result = new ListNode(0);
            ListNode p2 = result;

            while(p != null){
                if(duplicates.contains(p.val)){
                    p = p.next;
                }else{
                    p2.next = new ListNode(p.val);
                    p = p.next;
                    p2 = p2.next;
                }
            }

            return result.next;
        }


    }
}
