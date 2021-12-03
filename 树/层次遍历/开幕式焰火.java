import java.util.HashSet;

public class 开幕式焰火 {
    class Solution {
        private HashSet set = new HashSet<Integer>();
        public int numColor(TreeNode root) {
            if(root == null) return 0;
            set.add(root.val);
            numColor(root.left);
            numColor(root.right);
            return set.size();
        }
    }
}
