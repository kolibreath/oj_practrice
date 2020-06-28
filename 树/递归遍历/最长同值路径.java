import java.util.LinkedList;
import java.util.List;

public class 最长同值路径 {
    static  class Solution {
        private int max = 0;
        private final List<List<Integer>> result = new LinkedList<>();
        private void dfs(TreeNode node, LinkedList<Integer> list){
            if(node == null) return;
            list.add(node.val);
            if(node.left == null && node.right == null) {
                result.add(new LinkedList<>(list));
            }
            dfs(node.left, list);
            dfs(node.right, list);
            list.removeLast();
        }
        public int longestUnivaluePath(TreeNode root) {
            dfs(root, new LinkedList<>());
            for (List<Integer> list: result) {
                int first = list.get(0);
                boolean flag = false;
                for (int i = 1; i < list.size() ; i++) {
                    if(first != list.get(i)) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                if(max < list.size()) max = list.size();
            }
            return max == 0 ? 0 : max -1;
        }
    }
}
