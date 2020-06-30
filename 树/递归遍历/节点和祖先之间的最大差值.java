import java.util.LinkedList;
import java.util.List;

public class 节点和祖先之间的最大差值 {
    static class Solution {
        int max = -1;
        LinkedList<Integer> prev = new LinkedList<>();
        private void dfs(TreeNode node){
            if(node == null) return;
            for (int pre: prev) {
                int diff = Math.abs(pre - node.val);
                if(diff > max) max = diff;
            }
            prev.add(node.val);
            dfs(node.left);
            dfs(node.right);
            prev.removeLast();
        }
        public int maxAncestorDiff(TreeNode root) {
            if(root == null) return 0;
            prev.add(root.val);
            dfs(root.left);
            dfs(root.right);
            return max;
        }
    }
}
