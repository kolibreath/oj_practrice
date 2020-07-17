import java.util.*;

public class 二叉树寻路 {
    static class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            LinkedList<Integer> result= new LinkedList<>();
            int N = (int) (Math.log(label) / Math.log(2)) + 1;
            while(label > 1){
                result.add(label);
                N--;
                label = (int) (3 * Math.pow(2, N - 1) - label/ 2- 1);
            }
            result.add(1);
            Collections.reverse(result);
            return result;
        }
    }
}