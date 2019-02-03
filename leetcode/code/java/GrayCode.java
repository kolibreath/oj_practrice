import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    static class Solution {
        public List<Integer> grayCode(int n) {
            if(n == 0){
                List<Integer> list = new LinkedList<>();
                list.add(0);
                return list;
            }
            List <Integer> cur = grayCode(n-1);
            int add = (int) Math.pow(2,n-1);
            for(int i = cur.size() -1 ;i>=0;i--){
                cur.add(cur.get(i) + add);
            }
            return cur;
        }
    }
}
