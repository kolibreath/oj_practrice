public class 二叉树中和为某一值的路径 {
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root,target);
            return result;
        }

        private void dfs(TreeNode node, List<Integer> cur,int target){
            if (node == null) return;
            if (target == node.val) {
                cur.add(node.val);
                result.add(cur);
            }
            cur.add(node.val);
            dfs(node.left, new ArrayList<>(cur), target - node.val);
            dfs(node.right,new ArrayList<>(cur), target - node.val);
        }
    }
}