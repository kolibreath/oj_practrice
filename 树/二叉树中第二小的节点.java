import java.util.Collections;
import java.util.LinkedList;

public class 二叉树中第二小的节点 {
    static class Solution {
        private LinkedList<Integer> list = new LinkedList<>();
        private void dfs(TreeNode node){
            if(node == null) return ;
            list.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }

        public int findSecondMinimumValue(TreeNode root) {
            dfs(root);
            Collections.sort(list);
            if(list.size() == 1) return -1;
            int min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if(min != list.get(i)){
                     min = list.get(i);
                     return min;
                }
            }
            return -1;
        }
    }
}
