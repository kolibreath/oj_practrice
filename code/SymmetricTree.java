public class SymmetricTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return compare(root.left,root.right);
        }

        public boolean compare(TreeNode left, TreeNode right){
            if(left ==null){
                return right == null;
            }
            if(right ==null) return false;

            if(left.val != right.val){
                return false;
            }
            return (compare(left.left,right.right)&& compare(left.right,right.left) );

        }
    }
}
