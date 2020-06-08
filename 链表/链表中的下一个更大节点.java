import java.util.ArrayList;
import java.util.List;

public class 链表中的下一个更大节点 {
    class Solution{
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                ListNode cur = head;
                int a = cur.val;//当前值

                boolean find = false;

                while (cur.next != null) {
                    int b = cur.next.val;
                    //遍历获取第一个大于当前值的数
                    if (b > a) {
                        list.add(b);
                        find = true;//找到设置flag
                        break;
                    }
                    cur = cur.next;
                }
                if (!find) {//没找到置为0
                    list.add(0);
                }
                head = head.next;//遍历下一个当前值
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
