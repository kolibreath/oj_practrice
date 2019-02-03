import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;
       public  ListNode(int x) { val = x; }
    }

    static class Solution {
        boolean flag = false;

        public ListNode deleteDuplicates(ListNode empty) {
            ListNode head = new ListNode(Integer.MAX_VALUE);
            head = empty;
            Set<Integer> set = new HashSet<>();
            Set<Integer> duplicates = new HashSet<>();

            while(head.next !=null){
                if(!set.contains(head.val)){
                    set.add(head.val);
                }else{
                    duplicates.add(head.val);
                }
                head = head.next;
            }
            return head;
        }

    }

}
