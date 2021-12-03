public class 检查子树 {
    class Solution {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            else if (t1 == null) return false;
            else if (t2 == null) return false;
            else {
                if(t1.val == t2.val) {
                    boolean left = checkSubTree(t1.left, t2.left);
                    boolean right = checkSubTree(t1.right, t2.right);
                    if (left && right) return true;
                }
                return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
            }
        }
    }
}
