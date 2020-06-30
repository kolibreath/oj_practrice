import java.util.*;
import java.util.stream.Collectors;

public class 删点成林 {
    static class Solution {
        private List<TreeNode> ans = new LinkedList<>();
        private Set<Integer> set = new HashSet<>();
        private boolean helper(TreeNode root, boolean parent){
            boolean del;
            if(root == null) return false;
            del = set.contains(root.val);
            if(helper(root.left, !del)) root.left = null;
            if(helper(root.right, !del)) root.right = null;

            if(!del && !parent) ans.add(root);
            return del;
        }
        public List<TreeNode> delNodes(TreeNode root, int[] delete) {
            set = Arrays.stream(delete).boxed().collect(Collectors.toSet());
            helper(root, false);
            return ans;
        }
    }
}
