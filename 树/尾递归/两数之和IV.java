import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 两数之和IV {
    class Solution {
        Set<Integer> set = new HashSet<>();
        private boolean dfs(TreeNode root, int k){
            if(root == null) return false;
            if(set.contains(k - root.val)) return true;
            set.add(root.val);
            return dfs(root.left, k) || dfs(root.right, k);
        }
        public boolean findTarget(TreeNode root, int k) {
            return dfs(root, k);
        }
    }
}
