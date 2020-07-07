import java.util.LinkedList;
import java.util.List;

public class 翻转二叉树已匹配先序遍历 {
    static class Solution {
        private int index = 0;
        private int[] voyage;
        private LinkedList<Integer> result = new LinkedList<>();
        private boolean dfs(TreeNode root){
            if(root == null) return true;
            if(root.val != voyage[index]) return false;
            index = index + 1;
            if(root.left != null && root.left.val != voyage[index]){
                result.add(root.val);
                return dfs(root.right) && dfs(root.left);
            }
            return dfs(root.left) && dfs(root.right);
        }

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            this.voyage = voyage;
            if(!dfs(root)) {
                result = new LinkedList<>();
                result.add(-1);
            }
            return result;
        }
    }
}