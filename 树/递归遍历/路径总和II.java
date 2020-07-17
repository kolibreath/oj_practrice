import java.util.*;

public class 路径总和 {
    static class Solution {
        private List<List<Integer>> result = new LinkedList<>();
        private int sum ;
        private void dfs(TreeNode root, LinkedList<Integer> path){
            if(root == null) return;
            path.add(root.val);
            if(root.left == null && root.right == null) {
                int value = path.stream().mapToInt((x) -> x).sum();
                if(value == sum) result.add(new LinkedList<>(path));
            }
            dfs(root.left,path);
            dfs(root.right, path);
            path.removeLast();
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            this.sum = sum;
            dfs(root, new LinkedList<>());
            return result;
        }
    }
}