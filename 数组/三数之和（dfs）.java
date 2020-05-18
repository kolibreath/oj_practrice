import java.awt.peer.TrayIconPeer;
import java.util.*;

public class 三数之和 {
    class Solution {

        public class Triple{
            LinkedList<Integer> list;

            @Override
            public boolean equals(Object obj) {
                Triple that = (Triple) obj;
                //需要拷贝一个内容出来 最好不要直接修改引用
                LinkedList<Integer> thatListCopy = new LinkedList<>(that.list);
                LinkedList<Integer> thisListCopy = new LinkedList<>(this.list);

                Collections.sort(thatListCopy);
                Collections.sort(thisListCopy);

                for (int i = 0; i < 3; i++) {
                    if(!thatListCopy.get(i).equals(thisListCopy.get(i))){
                        return false;
                    }
                }


                return true;
            }

            public Triple(LinkedList<Integer> list){
                this.list = new LinkedList<>(list);
            }
        }

        public LinkedList<Triple> stack = new LinkedList<>();

        public void dfs(int index, int[] nums, LinkedList<Integer> save){
            if(save.size() == 3){
                //检查是不是等于0
                int sum = 0;
                int i = 0;
                for (i = 0; i < save.size(); i++) {
                    sum += save.get(i);
                }
                if(sum != 0 || i != 3)
                    return;
                //再检查是否出现过在这个stack中
                if(!stack.contains(new Triple(save)))
                    stack.add(new Triple(save));
                return;
            }
            for (int i = index; i < nums.length ; i++) {
                save.add(nums[i]);
                dfs(i + 1, nums , save);
                save.pollLast();
            }
        }

        public List<List<Integer>> threeSum(int[] nums) {
            dfs(0,nums, new LinkedList<>());
            List<List<Integer>> list= new LinkedList<>();
            for (Triple i : stack){
                list.add(i.list);
            }
            return list;
        }
    }
}
