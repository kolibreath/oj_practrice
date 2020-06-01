public class 相交链表 {
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            boolean cross = false;
            ListNode p = headA;
            ListNode q = headB;
            int cp = 0, cq = 0;
            while(p != null){
             cp++;
             p = p.next;
            }

            while(q != null){
                cq ++;
                q = q.next;
            }

            p = headA;
            q = headB;

            if(cp < cq ){
                int substract = cq - cp;
                while(substract-- > 0){
                    q = q.next;
                }
            }else{
                int substract = cp - cq ;
                while(substract -- > 0){
                    p = p.next;
                }
            }

            while(p!= null && q != null){
                  if(p == q ){
                      return q;
                  }
                 p = p.next;
                 q = q.next;
            }
            return null;
        }
    }
}
