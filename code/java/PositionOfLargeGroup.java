import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PositionOfLargeGroup {
   static  class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            if(S.length() < 3)
                return new ArrayList<>();

            Stack<Character> stack = new Stack<>();

            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<S.length();i++){
                if(stack.isEmpty()) {
                    stack.add(S.charAt(i));
                    continue;
                }
                if(stack.peek() == S.charAt(i)){
                    stack.add(S.charAt(i));
                }else{
                    int size = stack.size();
                    int start = i  - size;
                    int end = i -1 ;
                    stack.clear();
                    if((end - start + 1)>=3  ) {
                        List<Integer> l = new ArrayList<>();
                        l.add(start);
                        l.add(end);
                        list.add(l);
                    }
                    stack.add(S.charAt(i));
                }

            }
            return list;
        }
    }
}
