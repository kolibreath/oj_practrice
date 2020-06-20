import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的堂兄弟节点 {
    class Solution {
        private HashMap<Integer, Integer> depth = new HashMap<>();
        private HashMap<Integer, TreeNode>parents= new HashMap<>();

        private void dfs(TreeNode node, TreeNode parent){
            if(node == null) return ;
            depth.put(node.val, parent == null ? 0 : depth.get(parent.val) +1 );
            parents.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, null);
            return depth.get(x).equals(depth.get(y)) &&  parents.get(x) != parents.get(y);
        }
    }
}
