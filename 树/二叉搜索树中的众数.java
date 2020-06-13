import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class 二叉搜索树中的众数 {
    static class Solution {
        HashMap<Integer,Integer> hash = new HashMap<>();
        private void helper(TreeNode root){
            if(root == null) return ;
            hash.put(root.val, hash.getOrDefault(root.val,0)+1);
            helper(root.left);
            helper(root.right);
        }
        public int[] findMode(TreeNode root) {
            helper(root);
            int max = new ArrayList<>(hash.values()).get(0);
            LinkedList<Integer> result = new LinkedList<>();
            //跳过第一个
            boolean flag = false;
            for (Integer k :hash.keySet()) {
                if(!flag) {
                    flag = true;
                    continue;
                }
                int value  = hash.get(k);
                if(value>= max) {
                    max = value;
                    result.add(k);
                }
            }
            int r[] = new int[result.size()];
            for (int i = 0; i < result.size() ; i++) {
                r[i] = result.get(i);
            }
            return r;
        }
    }
}
