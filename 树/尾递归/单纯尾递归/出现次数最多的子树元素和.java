import java.util.*;

public class 出现次数最多的子树元素和 {
    static class Solution {
        private final HashMap<Integer,Integer> hash = new HashMap<>();
        private int dfs(TreeNode node){
            if(node == null) return 0;
            int left = dfs(node.left);
            int right= dfs(node.right);
            int cur = left + right + node.val;
            hash.put(cur, hash.getOrDefault(cur, 0) + 1);
            return cur;
        }
        public int[] findFrequentTreeSum(TreeNode root) {
            if(root == null) return new int[0];
            dfs(root);
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hash.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());

            int first = list.get(0).getValue();
            ArrayList<Integer> temp = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry: list) {
                if(first != entry.getValue()) break;
                temp.add(entry.getKey());
            }
            int index = 0;
            int result[] = new int[temp.size()];
            for (Integer i : temp) result[index ++] = i;
            return result;
        }
    }
}