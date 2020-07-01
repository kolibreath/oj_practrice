import java.util.*;

public class 二叉树中所有距离为K的节点 {
    class Solution {
        //key 是子节点 value 是父节点
        private HashMap<TreeNode, TreeNode> map = new HashMap<>();
        //key 是子节点 value是是否访问
        private HashMap<TreeNode, Boolean> visited = new HashMap<>();

        private LinkedList<Integer> result = new LinkedList<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if(k == 0) {
                result.add(target.val);
                return result;
            }

            dfs(root, null);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);
            visited.put(target, true);

            int step = 0;
            while(!queue.isEmpty()){
                step++;
                int size = queue.size();
                for (int i = 0; i < size ; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null && !visited.get(temp.left)){
                        if(step == k) result.add(temp.left.val);
                        queue.add(temp.left);
                        visited.put(temp.left, true);
                    }
                    if (temp.right != null && !visited.get(temp.right)){
                        if(step == k) result.add(temp.right.val);
                        queue.add(temp.right);
                        visited.put(temp.right, true);
                    }
                    TreeNode parent = map.get(temp);
                    if(parent != null && !visited.get(parent)){
                        if(step == k) result.add(parent.val);
                        queue.add(parent);
                        visited.put(parent, true);
                    }
                }
                if(step == k) break;
            }
            return result;
        }

        private void dfs(TreeNode node, TreeNode parent) {
            if(node == null) return;
            visited.put(node, false);
            map.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
