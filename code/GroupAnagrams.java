import java.util.LinkedList;
import java.util.List;

public class Combination {
   static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> out = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();

            helper(n,k,1,out,result);

            return result;
        }

        void helper(int n, int k, int level, List<Integer> out, List<List<Integer>> result){
            if(out.size() == k){
                List<Integer> cur = new LinkedList<>(out);
                result.add(cur);
                return;
            }
            for(int i = level;i<=n;i++){
                out.add(i);
                helper(n,k,i+1,out,result);
                Integer o = i;
                out.remove(o);
            }
        }
    }
}
