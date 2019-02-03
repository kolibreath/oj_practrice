public class RotateList {

   static public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null)
                return null;
            if(k == 0)
                return head;
            ListNode cur= head;
            int counter = 0;
            while(cur != null){
                cur = cur.next;
                counter++;
            }
            int numbers[] = new int[counter];
            cur = head;
            counter = 0;
            while(cur!= null){
                numbers[(counter+k)%numbers.length] = cur.val;
                cur = cur.next;
                counter ++ ;
            }
            ListNode newNode=  new ListNode(numbers[0]);
            ListNode newHead = newNode;
            for(int i =1;i<numbers.length ;i++){
                newNode.next = new ListNode(numbers[i]);
                newNode = newNode.next;
            }

            return newHead;
        }
    }
}
