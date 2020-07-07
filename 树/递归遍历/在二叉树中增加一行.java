import java.util.HashMap;

public class 在二叉树中增加一行 {
    static class Solution {
        private int depth;
        private int value;

        private HashMap<TreeNode,Boolean> map = new HashMap<>();
        private void dfs(TreeNode root, int level){
            if(root == null) return;
            boolean visited = map.getOrDefault(root, false);
            if(level == depth -1 && !visited){
                TreeNode left = root.left;
                TreeNode right= root.right;

                root.left = new TreeNode(value);
                root.right= new TreeNode(value);

                root.left.left = left;
                root.right.right = right;

                map.put(root, true);
                return ;
            }
            dfs(root.left, level + 1);
            dfs(root.right,level + 1);
        }
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            this.value = v;
            this.depth = d;
            if(depth  == 1){
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }
            dfs(root, 1);
            return root;
        }
    }
}
